import java.util.ArrayList;
import java.util.Optional;

public class Seller {
	
	private String name;
	private String type;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private String city;
	private float tax = 1;
	private int inventory_max_size;
	private float wear_increase=0;
	
	public Seller(String name, String type, String city) {
		super();
		this.name = name;
		this.type = type;
		this.city = city;
		if(type.equals("peasant"))
		{
			this.inventory_max_size = 5;
			this.tax = 1.02f;
			this.wear_increase = 15;
		}
		else if (type.equals("thief"))
		{
			this.inventory_max_size = 3;
			this.wear_increase = 25;
		}
		else if (type.equals("merchant"))
		{
			this.inventory_max_size = 7;
			this.tax = 1.04f;
		}	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void addItemToInventory(Item item) throws Exception
	{
		if(inventory.size()>=inventory_max_size) 
			throw new Exception("Inventario lleno!- El vendedor no puede comprar el ítem");
		if(item.getWear_percentage() + wear_increase >= 100)
			throw new Exception("Oh, el item se ha roto");
		
		item.setPrice(tax*item.getPrice());
		inventory.add(item);
	}
	
	public Item sellItem(String itemName) throws Exception
	{
		if(inventory.stream().anyMatch(item -> item.getName().equals(itemName)))
			throw new Exception("Aquest venedor no té l'objecte especificat");
		
		Optional<Item> it = inventory.stream()
						   .filter(item -> item.getName().equals(itemName))
						   .findFirst();
		inventory.removeIf(item -> item.getName().equals(itemName));
		return it.get();
	}
	
}
