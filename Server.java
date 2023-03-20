/* 
	File: Server.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/01/2023
    CS231B
    Creates a server that can process jobs in a queue or scheduling system.
*/

/**

A Server class that contains a queue of jobs and processes them based on their remaining time and the system time
*/
public class Server {
    double sysTime; // the current system time
    Queue<Job> sysQueue; // a queue of jobs waiting to be processed
    double totalWork; // the total amount of work remaining in the server's queue
    
    /**
    
    Constructor that initializes the Server object with default values
    */
    public Server() {
    sysTime = 0;
    sysQueue = new LinkedList<>();
    totalWork = 0;
    }
    /**
    
    Adds a job to the server's queue and updates the total amount of work remaining in the queue
    @param job the Job object to be added to the queue
    */
    public void addJob(Job job) {
    sysQueue.offer(job);
    totalWork += job.getTotalProcessingTime();
    }
    /**
    
    Processes jobs in the server's queue up to the given time.
    
    Updates the system time, the remaining work in the server's queue, and the jobs' processed time and finish time.
    
    @param time the time up to which the jobs in the queue will be processed
    */
    public void processTo(double time) {
    double myTimeRemaining = time - sysTime;
    
    while ((sysQueue.size() > 0) && (myTimeRemaining > 0)) {
    Job currentJob = sysQueue.peek();
    double timeToProcess = currentJob.getTimeRemaining();
    if (timeToProcess >= myTimeRemaining) {
        currentJob.process(myTimeRemaining);
        totalWork -= myTimeRemaining;
        sysTime += myTimeRemaining;
        currentJob.setFinishTime(sysTime);
        myTimeRemaining = 0;
    } else {
        currentJob.process(timeToProcess);
        totalWork -= timeToProcess;
        myTimeRemaining -= timeToProcess;
        sysTime += timeToProcess;
        currentJob.setFinishTime(sysTime);
        sysQueue.poll();
    }
}

sysTime = time;
}

/**

Returns the total amount of work remaining in the server's queue
@return the total amount of work remaining in the server's queue
*/
public double remainingWorkInQueue() {
return totalWork;
}
/**

Returns the number of jobs in the server's queue
@return the number of jobs in the server's queue
*/
public int size() {
return sysQueue.size();
}
/**

Main method for testing the Server class
*/
public static void main(String[] args) {
// Setup
Job job = new Job(0, 20);
Job job2 = new Job(10, 30);
Job job3 = new Job(20, 10);
Job job4 = new Job(25, 30);

Server server = new Server();
server.addJob(job);
server.addJob(job2);
server.addJob(job3);
server.addJob(job4);

// Test
System.out.println(server.remainingWorkInQueue() + " == 90.0");

server.processTo(55);
System.out.println(server.sysTime + " == 50.0");
System.out.println(server.sysQueue.peek().getTimeProcessed() + " == 10.0");
System.out.println(server.sysQueue.peek().getTimeRemaining() + " == 10.0");
System.out.println(server.remainingWorkInQueue() + " == 80.0\n");

}
}
   