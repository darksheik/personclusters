package personclusters;

import java.util.Comparator;

/**
 * This class exists to define how people will be sorted relative to the center of a Cluster object
 * @author Don Pflaster
 */
public class PersonComparator implements Comparator<Person> {
	 
	private Person cc;
	
	    @SuppressWarnings("unused")
		private PersonComparator() {
	    	// Should not be used without the cluster center
	    }
	    public PersonComparator(Person clusterCenter) {
	    	cc = clusterCenter;
	    }
        public int compare(Person p1, Person p2) {

            if (EuclideanDistanceCalculator.distance(p1, cc) > 
                EuclideanDistanceCalculator.distance(p2, cc))
 		   { return 1; }
              else if (EuclideanDistanceCalculator.distance(p1,cc) > 
              EuclideanDistanceCalculator.distance(p2, cc))
 		   { return -1; }  
             else return 0;
            

        }

   
}
