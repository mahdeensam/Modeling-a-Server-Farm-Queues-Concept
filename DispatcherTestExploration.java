/* 
	Hypothesis 1
*/

// Test for LeastWorkDispatcher
public class DispatcherTestExploration {
    public static void main(String[] args) {

        double totalTimeInQueue = 0;
        JobReader jr = new JobReader();
        LeastWorkDispatcher dispatcher = new LeastWorkDispatcher(34);

        dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));
        // dispatcher.handleJobs(jr.readJobFile("JobSequence_7_30.txt"));
        // dispatcher.handleJobs(jr.readJobFile("JobSequence_10_100.txt"));

        for (Job job : dispatcher.storeJobs) {
            totalTimeInQueue += job.timeInQueue();
        }

        double average = totalTimeInQueue / dispatcher.storeJobs.size();

        System.out.println("The average wait time in the jobs queue is " + average + ".");
    }
}


// //Test for RandomDispatcher
//  public class DispatcherTestExploration {
//      public static void main(String[] args) {

//          double totalTimeInQueue = 0;
//          JobReader jr = new JobReader();
//          RandomDispatcher dispatcher = new RandomDispatcher(34);

//          dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));

//          for (Job job : dispatcher.storeJobs) {
//              totalTimeInQueue += job.timeInQueue();
//          }

//          double average = totalTimeInQueue / dispatcher.storeJobs.size();

//          System.out.println("The average wait time in the jobs queue is " + average + ".");
//      }
//       }



// // Test for RoundRobinDispatcher
//  public class DispatcherTestExploration {
//      public static void main(String[] args) {

//          double totalTimeInQueue = 0;
//          JobReader jr = new JobReader();
//          RoundRobinDispatcher dispatcher = new RoundRobinDispatcher(34);

//          dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));

//          for (Job job : dispatcher.storeJobs) {
//              totalTimeInQueue += job.timeInQueue();
//          }

//          double average = totalTimeInQueue / dispatcher.storeJobs.size();

//          System.out.println("The average wait time in the jobs queue is " + average + ".");
//      }
//  }



//  // Test for ShortestQueueDispatcher
// public class DispatcherTestExploration {
//      public static void main(String[] args) {

//          double totalTimeInQueue = 0;
//          JobReader jr = new JobReader();
//          ShortestQueueDispatcher dispatcher = new ShortestQueueDispatcher(34);

//          dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));

//          for (Job job : dispatcher.storeJobs) {
//              totalTimeInQueue += job.timeInQueue();
//          }

//          double average = totalTimeInQueue / dispatcher.storeJobs.size();

//          System.out.println("The average wait time in the jobs queue is " + average + ".");
//      }
//  }



// /* 
// 	Hypothesis 2
// */

// // Test for RandomDispatcher
//  public class DispatcherTestExploration {
//      public static void main(String[] args) {
//          JobReader jr = new JobReader();
//          RandomDispatcher dispatcher = new RandomDispatcher(3);
//          dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));
//          double arrivalRate = 1.0 / 15; // Average time between job arrivals
//          double processingTime = 20.0; // Total units of processing time per job

//          double estimatedNumServers = arrivalRate * processingTime;
//          int actualNumServers = dispatcher.hashCode();

//          System.out.println("Estimated number of servers needed: " + estimatedNumServers);
//          System.out.println("Actual number of servers used: " + actualNumServers);

//          if (estimatedNumServers > actualNumServers) {
//              System.out.println("WARNING: Not enough servers to handle job sequence efficiently.");
//          } else {
//              System.out.println("Number of servers is sufficient to handle job sequence efficiently.");
//          }
//      }
//      }


// // Test for LeastWorkDispatcher
//  public class DispatcherTestExploration {
//      public static void main(String[] args) {
//          JobReader jr = new JobReader();
//          LeastWorkDispatcher dispatcher = new LeastWorkDispatcher(3);
//          dispatcher.handleJobs(jr.readJobFile("JobSequence_3_100.txt"));
//          double arrivalRate = 1.0 / 15; // Average time between job arrivals
//          double processingTime = 20.0; // Total units of processing time per job

//          double estimatedNumServers = arrivalRate * processingTime;
//          int actualNumServers = dispatcher.hashCode();

//          System.out.println("Estimated number of servers needed: " + estimatedNumServers);
//          System.out.println("Actual number of servers used: " + actualNumServers);

//          if (estimatedNumServers > actualNumServers) {
//              System.out.println("WARNING: Not enough servers to handle job sequence efficiently.");
//          } else {
//              System.out.println("Number of servers is sufficient to handle job sequence efficiently.");
//          }
//      } }