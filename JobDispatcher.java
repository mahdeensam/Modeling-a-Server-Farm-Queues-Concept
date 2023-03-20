/* 
	File: JobDispatcher.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/01/2023
    CS231B
    Provides functionality for dispatching jobs to servers in a queue or scheduling system.
*/


public abstract class JobDispatcher {

    protected LinkedList<Server> serverCollection;
double sysTime;
LinkedList<Job> storeJobs;

public JobDispatcher(int k) {
    serverCollection = new LinkedList<>();
    storeJobs = new LinkedList<>();

    for (int i = 0; i < k; i++) {
        serverCollection.offer(new Server());
    }
    sysTime = 0;
}

public void advanceTimeTo(double time) {

    for (Server server : serverCollection) {
        server.processTo(time);
    }

    sysTime = time;
}

public void finishUp() {

    double max = Double.NEGATIVE_INFINITY;
    for (Server server : serverCollection) {
        if (server.remainingWorkInQueue() > max) {
            max = server.remainingWorkInQueue();
        }
    }

    advanceTimeTo(sysTime + max);
}

public void handleJob(Job job) {
    advanceTimeTo(job.getArrivalTime());
    pickServer(job).addJob(job); // pick a server for the job and add job to the server
}

public void handleJobs(Queue<Job> jobs) {
    /*
     * Polls jobs in the Queue of jobs and uses it for the handleJob method
     * Calls finish up after polling all jobs in queue
     */
    int loop = jobs.size();
    for (int i = 0; i < loop; i++) {
        Job job = jobs.poll();
        storeJobs.add(job);
        handleJob(job);
    }

    finishUp();
}

public abstract Server pickServer(Job j);

/**
 * Calculate the average ratio of job size to its wait time.
 *
 * @return the average ratio of job size to its wait time
 */
public double averageJobSizeToWaitTimeRatio() {
    double totalRatio = 0;
    int totalJobs = 0;

    // Loop through all completed jobs and calculate the ratio of job size to wait time
    for (Job job : storeJobs) {
        double ratio = job.getSize() / (job.getFinishTime() - job.getArrivalTime() - job.getSize());
        totalRatio += ratio;
        totalJobs++;
    }

    // Return the average ratio
    return totalRatio / totalJobs;
}
}