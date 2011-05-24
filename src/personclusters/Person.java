package personclusters;

/**
 * A Person is read from a CSV file, with information about their name, weight, and height
 * @author Don Pflaster
 */
public class Person {

	private String personName;
	private Integer height;
	private Integer weight;
	
	// Constructor for persons whose height and weight are known
	public Person(String personName, Integer weightin, Integer heightin) {
		this.setPersonName(personName);
		this.setWeight(weightin);
		this.setHeight(heightin);

	}
	public Person() {
	    
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
    public String getPersonName() {
    	return personName;
    }

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getHeight() {
		return height;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}
	
	
}
