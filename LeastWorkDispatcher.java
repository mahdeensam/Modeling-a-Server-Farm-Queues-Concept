/* 
	File: LeastWorkDispatcher.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/05/2023
    CS231B
    Provides a specific server selection policy for dispatching jobs to servers in a queue or scheduling system.
*/



public class LeastWorkDispatcher extends JobDispatcher {

    public LeastWorkDispatcher(int k) {
        super(k);
    }

    public Server pickServer(Job j) {
        /*
         * Return server in serverCollection with the least work or least time remaining
         */
        Server leastServer = serverCollection.get(0);

        for (Server server : serverCollection) {
            if (server.remainingWorkInQueue() < leastServer.remainingWorkInQueue()) {
                leastServer = server;
            }
        }

        return leastServer;
    }
}