/* 
	File: Job.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/01/2023
    CS231B
    Creates a job in a queue or scheduling system.
*/

/**
 * A class representing a job to be processed by a server.
 * The job has an arrival time, a processing time, and keeps track of its current processed time and finished time.
 */
public class Job {
    double arrivalTime;         // the time at which the job arrives at the server
    double processingTime;      // the time it takes to process the job
    double currProcessedTime;   // the current amount of time the job has been processed
    double finishedTime;        // the time at which the job finishes processing

    /**
     * Constructor for the Job class.
     * @param arrivalTime The time at which the job arrives at the server.
     * @param processingTime The time it takes to process the job.
     */
    public Job(double arrivalTime, double processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.currProcessedTime = 0;
        this.finishedTime = 0;
    }

    /**
     * Getter method for the job's arrival time.
     * @return The job's arrival time.
     */
    public double getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Getter method for the job's total processing time.
     * @return The job's total processing time.
     */
    public double getTotalProcessingTime() {
        return processingTime;
    }

    /**
     * Checks whether the job has finished processing.
     * @return True if the job is finished, false otherwise.
     */
    public boolean isFinished() {
        return currProcessedTime == processingTime;
    }

    /**
     * Calculates the time the job spent in the server queue.
     * @return The time the job spent in the server queue.
     */
    public double timeInQueue() {
        return finishedTime - arrivalTime;
    }

    /**
     * Getter method for the job's finish time.
     * @return The job's finish time.
     */
    public double getFinishTime() {
        return finishedTime;
    }

    /**
     * Setter method for the job's finish time.
     * @param time The job's finish time.
     */
    public void setFinishTime(double time) {
        finishedTime = time;
    }

    /**
     * Getter method for the job's current processed time.
     * @return The job's current processed time.
     */
    public double getTimeProcessed() {
        return currProcessedTime;
    }

    /**
     * Calculates the time remaining for the job to finish processing.
     * @return The time remaining for the job to finish processing.
     */
    public double getTimeRemaining() {
        return processingTime - currProcessedTime;
    }

    /**
     * Adds time to the job's current processed time.
     * @param time The amount of time to add.
     */
    public void process(double time) {
        currProcessedTime += time;
    }

}
