package NPChierarchy;

import java.util.ArrayList;

import otherClasses.City;
import otherClasses.Item;

public abstract class Seller extends NPC
{
	protected ArrayList<Item> inventory = new ArrayList<Item>();

	public Seller(String name, City city)
	{
		super(name, city);
	}

	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

	public abstract String getType();
	
	public abstract void addItem(Item item) throws Exception;

	public abstract Item getItem(String name) throws Exception;

	public abstract void removeItem(Item item) throws Exception;

	public abstract boolean containsItem(Item item);

	public abstract boolean containsItem(String name);

	@Override
	public String toString() {
		return "Seller [inventory=" + inventory + ", name=" + name + ", city=" + city + "]";
	}

}
