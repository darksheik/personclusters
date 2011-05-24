package personclusters;

/**
 * Contains a single static method to calculate the distance between two points.  Accepts two Persons, and assumes weight and height are already set.
 * @author Don Pflaster
 */
public class EuclideanDistanceCalculator  {

	public static double distance(Person a, Person b) {
		
		double weightdiff = a.getWeight() - b.getWeight();
		double heightdiff = a.getHeight() - b.getHeight();		
		return Math.sqrt(Math.pow(weightdiff,2) + Math.pow(heightdiff,2) );

	}
}
