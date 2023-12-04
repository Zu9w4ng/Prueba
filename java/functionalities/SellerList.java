package functionalities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import NPChierarchy.*;
import otherClasses.City;
import otherClasses.Item;

public class SellerList
{
	private static ArrayList<Seller> sellers = new ArrayList<Seller>();

	public static ArrayList<Seller> getSellers() {
		return sellers;
	}

	public static void setSellers(ArrayList<Seller> sellers) {
		SellerList.sellers = sellers;
	}

	public static void addSeller(String name, City city, String type) throws Exception
	{
		if(containsSeller(name, city))
			throw new Exception("Aquest venedor ja existeix");

		switch (type.toLowerCase())
		{
		case "merchant":
			sellers.add(new Merchant(name, city));
			break;
		case "peasant":
			sellers.add(new Peasant(name, city));
			break;
		case "thief":
			sellers.add(new Thief(name, city));
			break;
		default:
			throw new Exception("error inesperat addSeller");
		}	
	}
	
	public static void addItemToSeller(Item item, NPC seller) throws Exception
	{
		if(!containsSeller(seller.getName(), seller.getCity()))
			throw new Exception("Aquest comprador no existeix en aquesta ciutat");

		Optional<Seller> sellerOfInterest = sellers.stream()
				.filter(s -> s.getName().equals(seller.getName())
						&& s.getCity().equals(seller.getCity()))
				.findFirst();
		
		sellerOfInterest.get().addItem(item);
	}

	public static boolean containsSeller(String name, City city) throws Exception
	{
		return sellers.stream().anyMatch(s -> s.getName().equals(name)
				&& s.getCity().equals(city));
		
	}

	public static Item cheapestItemInCity(City city) throws Exception
	{
		if (!sellers.stream().anyMatch(seller -> seller.getCity().equals(city))) 
			throw new Exception("Aquesta ciutat no té venedors registrats");

		ArrayList<Item> itemsInCity = new ArrayList<Item>();
		sellers.stream()
		.filter(seller -> seller.getCity().equals(city))
		.forEach(sInCity -> itemsInCity.addAll(sInCity.getInventory()));

		itemsInCity.sort((a,b) -> (a.getPrice() - b.getPrice())<=0 ? -1 : 1);
		return itemsInCity.get(0);
	}

	public static ArrayList<Item> sellerInventory(NPC seller) throws Exception
	{
		if (!sellers.stream().anyMatch(s -> s.getName().equals(seller.getName())
				&& s.getCity().equals(seller.getCity())))
			throw new Exception("Aquest venedor no existeix en aquesta ciutat");

		Optional<Seller> sellerOfInterest = sellers.stream()
				.filter(s -> s.getName().equals(seller.getName())
						&& s.getCity().equals(seller.getCity()))
				.findFirst();

		return sellerOfInterest.get().getInventory();
	}

	public static List<Seller> sellersInCity(City city)
	{
		List<Seller> sInCity = sellers.stream()
				.filter(seller -> seller.getCity().equals(city))
				.toList();

		return sInCity;
	}

	public static List<Item> itemTypeOrdered(String itemType)
	{		
		return  sellers.stream()
				.flatMap(s -> s.getInventory().stream())
				.filter(i -> i.getType().equals(itemType))
				.sorted((a,b) -> (a.getPrice() - b.getPrice())<=0 ? -1 : 1)
				.toList();

	}
}
