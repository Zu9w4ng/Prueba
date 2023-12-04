package otherClasses;

import java.util.ArrayList;
import java.util.Objects;

public class Player
{
	private String name;
	private City city;
	private ArrayList<Item> inventory = new ArrayList<Item>();

	public Player(String name, City city)
	{
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public void addItem(Item item) throws Exception
	{
		inventory.add(item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(city, other.city) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", city=" + city + ", inventory=" + inventory + "]";
	}
	

}
