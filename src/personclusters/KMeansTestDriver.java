package personclusters;


import java.util.logging.Logger;

/**
* The main program driver.  
* @author Don Pflaster
*/
public class KMeansTestDriver {

	/**
	* This constant controls how many people will be considered in the sets
	*/
	private static final Integer HOWMANYCLOSESTPEOPLE = 5;
	  
	public static void main(String[] args) {
		
	    Logger logger = KMeansLogger.getInstance().getLogger();	    		
		logger.info("KMeansTestDriver program beginning");
		
		KMeansClusterCreator kcc = new KMeansClusterCreator(1000,HOWMANYCLOSESTPEOPLE);
        
		int i = 0;  // i is just for the purpose of showing in which iteration we are
        for (Cluster c : kcc.getClusterList()) {
         i++;
	     System.out.println("==============");
	     System.out.println("Iteration " + i);
	     
	     // Retrieve and display the original cluster center, 
	     // which has been preserved for informational purposes
	     ClusterCenter occ = c.getOriginalcc();
	     System.out.println("Original center: " + occ.getWeight() + "," + occ.getHeight());
	     System.out.println("People in set:");
	     
         // Display the list of people closest to the original center,
	     // along with their weights, heights, and distances
	     for (Person p: c.getClosest() ) {
	    	 System.out.print(p.getPersonName());
	    	 System.out.print("," + p.getWeight());
	    	 System.out.print("," + p.getHeight());
	    	 System.out.println(",Dist: " + EuclideanDistanceCalculator.distance(p,occ));
	     }
	     
	     // Retrieve and display the newly calculated cluster center
	     ClusterCenter cc = c.getClusterCenter();
	     System.out.println("Averaged new cluster center: " + cc.getWeight() + "," + cc.getHeight());
        }	 
	}

}
