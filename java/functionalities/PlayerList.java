package functionalities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import NPChierarchy.*;
import otherClasses.*;

public class PlayerList
{
	private static ArrayList<Player> players = new ArrayList<Player>();

	public static void addPlayer(String name, City city) throws Exception
	{
		if(containsPlayer(name, city))
			throw new Exception("Aquest comprador ja existeix");

		players.add(new Player(name,city));
	}
	
	public static void addItemToPlayer(Item item, Player player) throws Exception
	{
		if(!containsPlayer(player.getName(), player.getCity()))
			throw new Exception("Aquest comprador no existeix en aquesta ciutat");

		Optional<Player> playerOfInterest = players.stream()
				.filter(s -> s.getName().equals(player.getName())
						&& s.getCity().equals(player.getCity()))
				.findFirst();
		
		playerOfInterest.get().addItem(item);
	}

	public static boolean containsPlayer(String name, City city) throws Exception
	{
		return players.stream().anyMatch(s -> s.getName().equals(name)
				&& s.getCity().equals(city));
	}

	public static void doTransaction(String itemName, Player player, NPC seller) throws Exception
	{
		if(!players.stream().anyMatch(p -> (p.getCity().equals(new City(player.getCity().getName())))))
			throw new Exception("Aquest client no existeix en aquesta ciutat");

		if (!SellerList.getSellers().stream().anyMatch(s -> (s.getCity().equals(new City(seller.getCity().getName())))))
			throw new Exception("Aquest venedor no existeix en aquesta ciutat");

		Optional<Seller> sellerOfInterest = SellerList.getSellers().stream()
				.filter(s -> s.getName().equals(seller.getName())
						&& s.getCity().equals(seller.getCity()))
				.findFirst();
		Optional<Player> playerOfInterest = players.stream()
				.filter(p -> p.getName().equals(player.getName())
						&& p.getCity().equals(player.getCity()))
				.findFirst();

		playerOfInterest.get().addItem(sellerOfInterest.get().getItem(itemName));
		sellerOfInterest.get().removeItem(sellerOfInterest.get().getItem(itemName));
	}

	public static ArrayList<Item> playerInventory(Player player) throws Exception
	{
		if (!players.stream().anyMatch(s -> s.getName().equals(player.getName())
				&& s.getCity().equals(player.getCity())))
			throw new Exception("Aquest comprador no existeix en aquesta ciutat");

		Optional<Player> playerOfInterest = players.stream()
				.filter(s -> s.getName().equals(player.getName())
						&& s.getCity().equals(player.getCity()))
				.findFirst();

		return playerOfInterest.get().getInventory();
	}

	public static List<Player> playersInCity(City city)
	{
		List<Player> pInCity = players.stream()
				.filter(p -> p.getCity().equals(city))
				.toList();

		return pInCity;
	}
}
