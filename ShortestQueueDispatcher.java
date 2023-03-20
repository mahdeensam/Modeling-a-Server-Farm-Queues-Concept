/* 
	File: ShortestQueueDispatcher.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/01/2023
    CS231B
    Provides a specific server selection policy for dispatching jobs to servers in a queue or scheduling system.
    Implements Shortest Job First (SJF) policy where jobs are ordered by their processing time and the server with the shortest job is chosen.
*/



public class ShortestJobFirstDispatcher extends JobDispatcher {

    Server shortestServer;

    public ShortestJobFirstDispatcher(int k) {
        super(k);
        shortestServer = null;
    }

    public Server pickServer(Job j) {
        /*
         * Return the server with the shortest job in queue
         */

        if (serverCollection.size() > 0) {
            shortestServer = serverCollection.get(0);
        } else {
            return null;
        }

        double shortestJobTime = Double.POSITIVE_INFINITY; // initialize the shortest job time as infinity

        // Loop through all servers and find the one with the shortest job in queue
        for (Server server : serverCollection) {
            for (Job job : server.getJobsInQueue()) {
                double jobTime = job.getTimeRemaining(); // get the remaining processing time for the job
                if (jobTime < shortestJobTime) {
                    shortestJobTime = jobTime;
                    shortestServer = server;
                }
            }
        }

        return shortestServer;
    }
}
