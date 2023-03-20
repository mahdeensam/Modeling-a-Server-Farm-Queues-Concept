/* 
	File: JobReader.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/01/2023
    CS231B
    Reads a job file and creates a Queue of Job objects from the data.
*/

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;;

public class JobReader {
    public Queue<Job> readJobFile(String filename) {

        try {
            // assign to a variable of type FileReader a new FileReader object, passing
            // filename to the constructor
            FileReader fr = new FileReader(filename);
            // assign to a variable of type BufferedReader a new BufferedReader, passing fr
            // to the constructor
            BufferedReader br = new BufferedReader(fr);
            // assign to a variable of type Queue<Job> a new LinkedList.
            Queue<Job> jobSequence = new LinkedList<Job>();

            // assign to a variable of type String line the result of calling the readLine
            // method of the BufferedReader.
            String line = br.readLine();
            // everytime we call br.readLine(), we advance to the next line of the file we
            // are reading.
            // Since the first line of the job files are just the headers,
            // let's skip the first line by calling br.readLine again:
            line = br.readLine();
            // start a while loop that loops while line isn't null
            while (line != null) {
                // assign to an array of type String the result of calling split on the line
                // with the argument ","
                String[] arr = line.split(",");
                // let's see what this array holds:
                // System.out.println("the first item in arr: " + arr[0] + ", the second item in
                // arr: " + arr[1]);
                // using this String array arr, make a new Job object and offer it into
                // jobSequence:
                Job newJob = new Job(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
                jobSequence.offer(newJob);
                line = br.readLine();
            }
            // call the close method of the BufferedReader:
            br.close();
            return jobSequence;
        } catch (FileNotFoundException ex) {
            System.out.println("JobReader.read():: unable to open file " + filename + ": file not found");
        } catch (IOException ex) {
            System.out.println("JobReader.read():: error reading file " + filename);
        }

        return null;
    }
//Extension 2 Work here
    public static void main(String[] args) {
        JobReader jr = new JobReader();
        JobDispatcher ranDispatcher = new RandomDispatcher(1);

        ranDispatcher.handleJobs(jr.readJobFile("shortJobSequence.txt"));

        double total = 0;
        for (Job job : ranDispatcher.storeJobs) {
            total += job.timeInQueue();
            System.out.println("Arrival time: " + job.arrivalTime + " Finish time: " + job.finishedTime);
        }

        System.out.println(total);

        double averageTimeInQueue = total / ranDispatcher.storeJobs.size();

        System.out.println(averageTimeInQueue);
    }
}