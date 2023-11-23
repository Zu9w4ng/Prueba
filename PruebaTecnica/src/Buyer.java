import java.util.ArrayList;

public class Buyer {

	private String name;
	private ArrayList<Item> acquired_items = new ArrayList<Item>();
	private String city;
	
	public Buyer(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Item> getAcquired_items() {
		return acquired_items;
	}

	public void setAcquired_items(ArrayList<Item> acquired_items) {
		this.acquired_items = acquired_items;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void addItemToAcquiredItems(Item item)
	{
		acquired_items.add(item);
	}
	
	
	
}
