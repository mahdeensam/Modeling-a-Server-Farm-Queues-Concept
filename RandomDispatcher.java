/* 
	File: RandomDispatcher.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/05/2023
    CS231B
    Provides a specific server selection policy for dispatching jobs to servers in a queue or scheduling system.
*/


// import the Random class
import java.util.Random;

public class RandomDispatcher extends JobDispatcher {
Random randomPicker;

public RandomDispatcher(int k) {
    // call the constructor of the parent class
    super(k);
    // create a new Random object
    randomPicker = new Random();
}

public Server pickServer(Job j) {
    // randomly select an index in the serverCollection using the nextInt() method of the Random class
    int randPick = randomPicker.nextInt(0, serverCollection.size());

    // return the server at the selected index
    return serverCollection.get(randPick);
}

public static void main(String[] args) {
    // create a new RandomDispatcher object with 1 server
    RandomDispatcher dispatcher = new RandomDispatcher(1);

    // create 2 new jobs
    Job job = new Job(0, 20);
    Job job2 = new Job(20, 30);

    // create a new LinkedList of jobs and add the 2 jobs
    Queue<Job> queueOfJobs = new LinkedList<>();
    queueOfJobs.offer(job);
    queueOfJobs.offer(job2);

    // handle the jobs using the dispatcher
    dispatcher.handleJobs(queueOfJobs);
}
}
