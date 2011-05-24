package personclusters;
import java.util.*;

/**
* A Cluster of people, which has a center and an ArrayList of Persons who are closest to it
* @author Don Pflaster
*/
public class Cluster {

	private List<Person> pl = DataFile.getInstance().getPersonList();
	private ClusterCenter cc;
    private ClusterCenter originalcc;
	private ArrayList<Person> closestPeople = new ArrayList<Person>();

	
	public Cluster() {
		 /* ClusterCenter is a subclass of Person
            with random weight-height values  */
		cc = new ClusterCenter(); 
		

	}
	
	/**
	 * Sets the closestPeople ArrayList to the Persons closest to the center point.
	 * 
	 * @param howMany The number of people that should be considered as closest
	 */
	public void setClosest(Integer howMany) {

		/* The cluster center must be passed into the comparator class
		   as it is not naturally occurring within the Person Class */
		Collections.sort(pl, new PersonComparator(cc));
		

		closestPeople = new ArrayList<Person>();
		Iterator<Person> iter = pl.iterator();
        
		Integer current = 0;
		while (current < howMany){
			closestPeople.add(iter.next());
		    current++;
		}
	}
	
	public ArrayList<Person> getClosest() {
		return closestPeople;
	}
	
	/**
	 * Sets the new center point of the cluster to the average of the people in the cluster.
	 * Preserves the original ClusterCenter object in the originalcc variable.
	 * 
	 */
	public void setNewCenter() {
		double heightsum = 0;
		double weightsum = 0;
		setOriginalcc(cc); // Preserve original center
		ArrayList<Person> al = getClosest();
        for (Person p : al) {
            heightsum += p.getHeight();
            weightsum += p.getWeight();
        	}
        cc = new ClusterCenter(
        		(int)Math.round(weightsum / al.size()),
        		(int)Math.round(heightsum / al.size())
        		);

	}
	
	public ClusterCenter getClusterCenter() {
		return cc;
	}

	public void setOriginalcc(ClusterCenter originalcc) {
		this.originalcc = originalcc;
	}

	public ClusterCenter getOriginalcc() {
		return originalcc;
	}


	
}
