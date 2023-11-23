
public class Item {
	
	private String name;
	private String type;
	private float price;
	private float wear_percentage;
	
	public Item(String name, String type, float price, float wear_percentage) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.wear_percentage = wear_percentage;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getWear_percentage() {
		return wear_percentage;
	}

	public void setWear_percentage(float wear_percentage) {
		this.wear_percentage = wear_percentage;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", type=" + type + ", price=" + price + ", wear_percentage=" + wear_percentage
				+ "]";
	}
	
	
	
}
