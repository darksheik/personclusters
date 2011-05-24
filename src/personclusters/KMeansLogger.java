package personclusters;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
* A logger for the application.  Implemented as a singleton. 
* @author Don Pflaster
*/
public class KMeansLogger {

	private static KMeansLogger kmlogger = null;
	private Logger logger;
	   
	private KMeansLogger() {
		   logger = Logger.getLogger("kmlogger");
		   
		    FileHandler fh;

		    try {

		      // This block configure the logger with handler and formatter
		      fh = new FileHandler("log\\kmlogger.log", true);
		      logger.addHandler(fh);
		      logger.setLevel(Level.ALL);
		      SimpleFormatter formatter = new SimpleFormatter();
		      fh.setFormatter(formatter);

		      // the following statement is used to log any messages   
		      logger.info("Logger created");

		    } catch (SecurityException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	
	public static KMeansLogger getInstance() {
    if(kmlogger == null) {
    	kmlogger = new KMeansLogger();
     }
     
     return kmlogger;
    }
    public Logger getLogger() {
    	return logger;
    }
}
