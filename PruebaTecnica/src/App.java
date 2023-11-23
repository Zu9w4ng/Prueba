import java.util.ArrayList;
import java.util.Optional;

public class App {

	public static void main(String[] args) {
		
		ArrayList<Seller> sellers = new ArrayList<Seller>();
		ArrayList<Buyer> buyers = new ArrayList<Buyer>();
		
	}
	
	public static void addSeller(ArrayList<Seller> sellers, String name, String type, String city) throws Exception
	{
		if(sellers.stream().anyMatch(seller -> (seller.getCity().equals(city) && 
												seller.getName().equals(name))))
			throw new Exception("Aquest venedor ja existeix en aquesta ciutat");
			
		sellers.add(new Seller(name, type, city));
	}
	
	public static void addItemToSeller(ArrayList<Seller> sellers, Item item, String sellerName, String sellerCity) throws Exception
	{
		if (!sellers.stream().anyMatch(seller -> (seller.getCity().equals(sellerCity) && 
									   			  seller.getName().equals(sellerName))))
			throw new Exception("Aquest venedor no existeix en aquesta ciutat");
		
		Optional<Seller> seller = sellers.stream()
				   .filter(s -> s.getName().equals(sellerName) &&
						   		s.getCity().equals(sellerCity))
				   .findFirst();
		
		seller.get().addItemToInventory(item);
	}
	
	public static Item cheapestItemInCity(ArrayList<Seller> sellers, String cityName) throws Exception
	{
		if (!sellers.stream().anyMatch(seller -> seller.getCity().equals(cityName))) 
			throw new Exception("Aquesta ciutat no té venedors registrats");
		
		ArrayList<Item> itemsInCity = new ArrayList<Item>();
		sellers.stream()
			   .filter(seller -> seller.getCity().equals(cityName))
			   .forEach(sInCity -> itemsInCity.addAll(sInCity.getInventory()));
		
		itemsInCity.sort((a,b) -> (a.getPrice() - b.getPrice())<=0 ? -1 : 1);
		return itemsInCity.get(0);
	}
	
	public static ArrayList<Item> sellerInventory(ArrayList<Seller> sellers, String sellerName, String sellerCity) throws Exception
	{
		if (!sellers.stream().anyMatch(seller -> (seller.getCity().equals(sellerCity) && 
	   			  								  seller.getName().equals(sellerName))))
			throw new Exception("Aquest venedor no existeix en aquesta ciutat");

		Optional<Seller> seller = sellers.stream()
				.filter(s -> s.getName().equals(sellerName) &&
							 s.getCity().equals(sellerCity))
				.findFirst();

		return seller.get().getInventory();
	}
	
	public static void addBuyer(ArrayList<Buyer> buyers, String name, String city) throws Exception
	{
		if(buyers.stream().anyMatch(buyer -> (buyer.getCity().equals(city) && 
												buyer.getName().equals(name))))
			throw new Exception("Aquest client ja existeix en aquesta ciutat");
			
		buyers.add(new Buyer(name, city));
	}
	
	public static void doTransaction(String itemName, ArrayList<Buyer> buyers, String buyerName, String buyerCity, ArrayList<Seller> sellers, String sellerName, String sellerCity) throws Exception
	{
		if(!buyers.stream().anyMatch(buyer -> (buyer.getCity().equals(buyerCity) && 
											   buyer.getName().equals(buyerName))))
			throw new Exception("Aquest client no existeix en aquesta ciutat");
		
		if (!sellers.stream().anyMatch(seller -> (seller.getCity().equals(sellerCity) && 
					  							  seller.getName().equals(sellerName))))
			throw new Exception("Aquest venedor no existeix en aquesta ciutat");

		Optional<Seller> seller = sellers.stream()
										 .filter(s -> s.getName().equals(sellerName) &&
												 	  s.getCity().equals(sellerCity))
										 .findFirst();
		Optional<Buyer> buyer = buyers.stream()
				 .filter(b -> b.getName().equals(buyerName) &&
						 	  b.getCity().equals(buyerCity))
				 .findFirst();
		
		buyer.get().addItemToAcquiredItems(seller.get().sellItem(itemName));
	}
	
	public static ArrayList<Item> buyerInventory(ArrayList<Buyer> buyers, String buyerName, String buyerCity) throws Exception
	{
		if (!buyers.stream().anyMatch(buyer -> (buyer.getCity().equals(buyerCity) && 
					  							buyer.getName().equals(buyerName))))
			throw new Exception("Aquest client no existeix en aquesta ciutat");

		Optional<Buyer> buyer = buyers.stream()
									  .filter(b -> b.getName().equals(buyerName) &&
												   b.getCity().equals(buyerCity))
									  .findFirst();

		return buyer.get().getAcquired_items();
	}
	
	public static ArrayList<Seller> sellersInCity(ArrayList<Seller> sellers, String cityName)
	{
		ArrayList<Seller> sInCity = (ArrayList<Seller>) sellers.stream()
				   											   .filter(seller -> seller.getCity().equals(cityName))
				   											   .toList();
		
		return sInCity;
	}
	
	public static ArrayList<Buyer> buyersInCity(ArrayList<Buyer> buyers, String cityName)
	{
		ArrayList<Buyer> bInCity = (ArrayList<Buyer>) buyers.stream()
				   .filter(seller -> seller.getCity().equals(cityName))
				   .toList();

		return bInCity;
	}
	
	public static ArrayList<Item> itemTypeOrdered(ArrayList<Seller> sellers, String itemType)
	{
		if (!sellers.stream().anyMatch(seller -> seller.getInventory()
													   .contains(itemType))) 
			throw new Exception("Aquest tipus d'objecte no existeix");
		
		Optional<ArrayList<Item>> items = sellers.stream()
													   .forEach(s -> getInventory()
															   .stream()
															   .filter(i -> i.getType().equals(itemType)))
													   		.toList();
													   
			   
			  
		ArrayList<Item> itemsInType = items.get();
		itemsInType.sort((a,b) -> (a.getPrice() - b.getPrice())<=0 ? -1 : 1);
		return itemsInType.get(0);
	}

}
