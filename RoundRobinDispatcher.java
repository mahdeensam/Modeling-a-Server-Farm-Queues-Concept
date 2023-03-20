/* 
	File: RoundRobinDispatcher.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/01/2023
    CS231B
    Provides a round-robin dispatching to servers in a queue or scheduling system.
*/

public class RoundRobinDispatcher extends JobDispatcher {

    private int currentServerIndex;

    public RoundRobinDispatcher(int k) {
        super(k);
        currentServerIndex = 0;
    }

    public Server pickServer(Job j) {
        /*
         * Return the next server in the circular order
         */
        Server server = serverCollection.get(currentServerIndex);
        currentServerIndex = (currentServerIndex + 1) % serverCollection.size();
        return server;
    }
}
