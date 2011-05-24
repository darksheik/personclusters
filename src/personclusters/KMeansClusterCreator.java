package personclusters;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
* A class designed to create a large number of Cluster objects. 
* @author Don Pflaster
*/
public class KMeansClusterCreator  {
     
	  private ArrayList<Cluster> cl = new ArrayList<Cluster>();
	  private Logger logger = KMeansLogger.getInstance().getLogger();
	  
      public KMeansClusterCreator(Integer numberOfClusters, Integer howManyClosestPeople) {
    	  for (Integer i=0; i < numberOfClusters; i++) {
    		  
    	     Cluster c = createCluster(howManyClosestPeople);
    	     cl.add(c);

    	  }
      }
      /**
      * Creates a single new cluster, automatically recalculating the center point based on the average of the people closest to the original center point.
      */
      private Cluster createCluster(Integer howManyClosestPeople) {
    	// Create the new cluster with a random center
    	Cluster c = new Cluster();
    	ClusterCenter cc = c.getClusterCenter();
    	logger.info("New cluster created with center " + cc.getWeight() + "," + cc.getHeight());
    	
    	// Find the X closest people (can be adjusted above)
    	c.setClosest(howManyClosestPeople);
        
      
        // Set the new center based on the top X
        c.setNewCenter();
    	logger.info("Center reset to " + cc.getWeight() + "," + cc.getHeight());
    	
        return c;
      }
      

      
      public ArrayList<Cluster> getClusterList() {
    	  return cl;
      }
}
