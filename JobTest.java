public class JobTest {
    public static void jobTest() {
        {
            // Setup
            Job job1 = new Job(0, 10);
            Job job2 = new Job(10, 20);

            // Verify
            System.out.println(job1.getArrivalTime() + " == 0.0");
            System.out.println(job2.getArrivalTime() + " == 10.0");

        }
        {
            // Setup
            Job job1 = new Job(0, 10);
            Job job2 = new Job(10, 20);

            // Verify
            System.out.println(job1.getTotalProcessingTime() + " == 10.0");
            System.out.println(job2.getTotalProcessingTime() + " == 20.0");

        }
        {
            // Setup
            Job job1 = new Job(0, 10);
            Job job2 = new Job(10, 20);

            // Test process, isFinished, setFinished, getTimeRemaining, and getFinished
            job1.process(10);
            job2.process(5);

            if (job1.isFinished()) {
                job1.setFinishTime(job1.getArrivalTime() + 10);
            }

            // Verify
            System.out.println(job1.timeInQueue() + " == 10.0");
            System.out.println(job2.getTimeRemaining() + " == 15.0");
            System.out.println(job1.isFinished() + " == true");
            System.out.println(job2.isFinished() + " == false");

            System.out.println(job1.getFinishTime() + " == 10.0");

        }
    }

    public static void main(String[] args) {
        jobTest();
    }
}
