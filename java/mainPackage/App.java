package mainPackage;

import functionalities.PlayerList;
import functionalities.SellerList;
import otherClasses.*;
import NPChierarchy.*;

public class App 
{
    public static void main(String[] args)
    {
    	boolean finished = false;
    	int select = 0;
    	
    	do
    	{
    		showMenu();
    		try {
				select = Input.readInt("Introdueix la acció:\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		switch (select)
    		{
    		case 1:
    			try {
    				String name = Input.readString("Introdueix el nom del venedor");
    				City city = new City(Input.readString("Introdueix el nom de la ciutat"));
    				String type = Input.readString("Introdueix el tipus del venedor");
    				
					SellerList.addSeller(name, city, type);
				} catch (Exception e) {
					e.printStackTrace();
				}
    			break;
    			
    		case 2:
    			try {
    				String name = Input.readString("Introdueix el nom del venedor");
    				City city = new City(Input.readString("Introdueix la ciutat del venedor"));
    				String itemName = Input.readString("Introdueix el nom de l'objecte a afegir");
    				String itemType = Input.readString("Introdueix el tipus d'objecte");
    				float price = Input.readFloat("Introdueix el preu base de l'item");
    				float wear = Input.readFloat("Introdueix el desgast inicial de l'item");
    				NPC seller = new NPC(name, city);
    				Item item = new Item(itemName, itemType, price, wear);
    				
					SellerList.addItemToSeller(item, seller);
				} catch (Exception e) {
					e.printStackTrace();
				}
    			break;
    		
    		case 3:
    			try {
    				
    				City city = new City(Input.readString("Introdueix el nom de la ciutat"));
					System.out.println(SellerList.cheapestItemInCity(city)); 
				} catch (Exception e) {
					e.printStackTrace();
				}
    			break;
    			
    		case 4:
    			try {
    				String name = Input.readString("Introdueix el nom del venedor");
        			City city = new City(Input.readString("Introdueix el nom de la ciutat"));
        			NPC seller = new NPC(name, city);
        			SellerList.sellerInventory(seller).forEach(System.out::println); 
    			} catch (Exception e){
    				e.printStackTrace();
    			}
    			break;
    			
    		case 5:
    			try {
    				String name = Input.readString("Introdueix el nom del comprador");
    				City city = new City(Input.readString("Introdueix el nom de la ciutat"));
    				
					PlayerList.addPlayer(name, city);
				} catch (Exception e) {
					e.printStackTrace();
				}
    			break;
    			
    		case 6:
    			try {
    				String itemName = Input.readString("Introdueix el nom de l'objecte a canviar");
        			String playerName = Input.readString("Introdueix el nom del comprador");
    				City playerCity = new City(Input.readString("Introdueix el nom de la ciutat"));
        			String sellerName = Input.readString("Introdueix el nom del venedor");
        			City sellerCity = new City(Input.readString("Introdueix el nom de la ciutat"));
        			Player player = new Player(playerName, playerCity);
        			NPC seller = new NPC(sellerName, sellerCity);
					PlayerList.doTransaction(itemName, player, seller);
				} catch (Exception e) {
					e.printStackTrace();
				}
    			break;
    			
    		case 7:
    			try {
    				String name = Input.readString("Introdueix el nom del comprador");
        			City city = new City(Input.readString("Introdueix el nom de la ciutat"));
        			Player player = new Player(name, city);
        			PlayerList.playerInventory(player).forEach(System.out::println); 
    			} catch (Exception e){
    				e.printStackTrace();
    			}
    			break;
    		
    		case 8:
    			try {
        			City city = new City(Input.readString("Introdueix el nom de la ciutat"));
        			SellerList.sellersInCity(city).forEach(System.out::println);
    			} catch (Exception e){
    				e.printStackTrace();
    			}
    			break;
    			
    		case 9:
    			try {
        			City city = new City(Input.readString("Introdueix el nom de la ciutat"));
        			PlayerList.playersInCity(city).forEach(System.out::println);
    			} catch (Exception e){
    				e.printStackTrace();
    			}
    			break;
    			
    		case 10:
    			try {
        			String type = Input.readString("Introdueix el tipus d'objecte");
        			SellerList.itemTypeOrdered(type).forEach(System.out::println);
    			} catch (Exception e){
    				e.printStackTrace();
    			}
    			break;
    			
    		case 11:
    			finished = true;
    			break;
    			
    		default:
    			System.out.println("Introdueix una acció vàlida");
    			break;
    		}
    	} while(!finished);
    }
    
    public static void showMenu()
    {
    	System.out.println(
    			"Escull la acció a realitzar:\n"
    			+ "1 - Crear un venedor\n"
    			+ "2 - Afegir un ítem a l'inventari d'un venedor\n"
    			+ "3 - Mostra l'ítem més barat dels venedors d'una ciutat\n"
    			+ "4 - Consulta els ítems d'un venedor\n"
    			+ "5 - Crea un comprador\n"
    			+ "6 - Un comprador compra un ítem a un venedor\n"
    			+ "7 - Consulta els ítems d'un comprador\n"
    			+ "8 - Consulta tots els venedors que hi han en una ciutat\n"
    			+ "9 - Consulta tots els compradors que hi han en una ciutat\n"
    			+ "10 - Mostra tots els ítems d'un tipus ordenats per preu\n"
    			+ "11 - Finalitza l'execució del programa");
    }
}
