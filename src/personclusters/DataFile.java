package personclusters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Reads the .csv file and creates an ArrayList of Person objects
 * @author Don Pflaster
 */
public class DataFile {

	private static DataFile df = null;
	private ArrayList<Person> personList = new ArrayList<Person>();
    private static Logger logger = KMeansLogger.getInstance().getLogger();
    private String dataFileName = "files/person_data.csv";
	private DataFile() {

	}
	
	public static DataFile getInstance() {
	/* This is implemented as a singleton so that we don't have to 
	 * reread the file each time
	 */
    if(df == null) {

        df = new DataFile();
        df.readFile();
     }
    
     return df;
    }
	/**
	 * Opens the csv file, splits the delimiter, and creates an ArrayList of new Person objects.
	 * 
	 * In this example, since the file is small, I am reading it into memory.
	 * If it were a very large file, I might choose to traverse the file each time I needed the data
	 */
	private void readFile() {
		/* In this example, since the file is small, I am reading it into memory.
		   If it were a very large file, I might choose to traverse the file each time
		   I needed the data.  */
	    BufferedReader br = null;
	    
	    try {
	      
	      br = new BufferedReader(new FileReader(dataFileName));
	      logger.info("Reading datafile: " + dataFileName);
	      String line = null;
	      
	      line = br.readLine(); // Skip header row
	      
	      while ((line = br.readLine()) != null) {
	        
	        String[] values = line.split(",");
	        logger.info("Adding " + values[1] + "-" + values[2]);
	        // Add the values to the array
	        personList.add(new Person(values[0],Integer.parseInt(values[1]),
	    		                               Integer.parseInt(values[2])));
	      }
	      logger.info("Size of personList = " + personList.size());

	    }
	    catch (FileNotFoundException ex) {
	      ex.printStackTrace();
	    }
	    catch (IOException ex) {
	      ex.printStackTrace();
	    }
	    finally {
	      try {
	        if (br != null)
	          br.close();
	      }
	      catch (IOException ex) {
	        ex.printStackTrace();
	      }
	    }
		
	}
	
	public ArrayList<Person> getPersonList() {
		return personList;
	}

}
