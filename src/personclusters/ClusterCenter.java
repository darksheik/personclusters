package personclusters;

import java.util.Random;

/**
 * The original center point of a Cluster, with weight and height randomly generated when instantiated.
 * Extends the Person class, as properties are similar.
 * @author Don Pflaster
 */
public class ClusterCenter extends Person {
	
	/* These are the upper and lower bounds for height and weight, 
	   used by random generator */
	private final Integer heightubound = 90;
	private final Integer heightlbound = 38;
	private final Integer weightubound = 150;
	private final Integer weightlbound = 50;

	/**
	 * Constructor is called without params when a random center is desired
	 */
	public ClusterCenter() {
		
		Random generator = new Random();
		this.setHeight(generator.nextInt( heightubound - heightlbound ) + heightlbound);
		this.setWeight(generator.nextInt( weightubound - weightlbound ) + weightlbound);
	
	}
	
	/**
	 * Constructor is called when a new ClusterCenter is calculated
	 */	
	public ClusterCenter(int weight, int height) {

		
		this.setWeight(weight);
		this.setHeight(height);
	}

}
