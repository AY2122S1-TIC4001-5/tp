package seedu.duke;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class Storage {
    private static String file_path;
    private BufferedReader fileRead;
    private File file;

    public FlightList flightList;
    public Storage(FlightList flightList){
        this.flightList = flightList;
    }

    /**
     * Read all flight details from DB file and store them to fightList
     */
    public void readFile() throws FileNotFoundException, IOException{
        BufferedReader fileRead = new BufferedReader(new FileReader("FlightDB.txt"));
        String line = fileRead.readLine();
        while(line != null){
            //String[] splitLine = line.split(" \\| ");
            flightList.addFlight(line);
            System.out.println(line.substring(4));
            line = fileRead.readLine();
        }
        System.out.println("You have " + flightList.getSize()
                                        + " flights in your record");
        fileRead.close();
    }

    /**
     * Save fight details into flightDB file
     */
     public static void saveToDB(String flightData) throws IOException {
         FileWriter fileWriter = new FileWriter("FlightDB.txt", true);
         PrintWriter printWriter = new PrintWriter(fileWriter);
         printWriter.println(flightData);
         fileWriter.close();
         printWriter.close();

     }

}