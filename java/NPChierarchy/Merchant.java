package NPChierarchy;

import java.util.Optional;

import otherClasses.City;
import otherClasses.Item;

public class Merchant extends Seller
{
	private static final int INV_SIZE = 7;
	private static final float TAX = 1.04f;
	private static final String type = "merchant";

	public Merchant(String name, City city)
	{
		super(name, city);
	}

	
	public String getType() {
		return type;
	}

	@Override
	public void addItem(Item item) throws Exception
	{
		if(inventory.size() >= INV_SIZE)
			throw new Exception("Mida màxima d'inventari, no es pot afegir un altre objecte");

		if(containsItem(item))
			throw new Exception("Aquest item ja existeix a l'inventari del venedor");

		item.setPrice(item.getPrice()*TAX);
		inventory.add(item);
	}

	@Override
	public Item getItem(String name) throws Exception
	{
		Optional<Item> item = inventory.stream()
				.filter(i -> i.getName().equals(name))
				.findFirst();

		return item.orElseThrow();
	}

	@Override
	public void removeItem(Item item) throws Exception
	{
		if(!containsItem(name))
			throw new Exception("Aquest item no existeix a l'inventari del venedor");

		inventory.removeIf(i -> i.equals(item));
	}

	@Override
	public boolean containsItem(Item item)
	{
		if(inventory.stream().anyMatch(i -> i.equals(item)))
			return true;
		return false;
	}

	@Override
	public boolean containsItem(String name)
	{
		if(inventory.stream().anyMatch(i -> i.getName().equals(name)))
			return true;
		return false;
	}

}
