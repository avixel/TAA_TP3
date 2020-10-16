package app.data;

public class Item {
	
	int id;
	double price;

	public Item(int i, double p) {
		this.id = i;
		this.price = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
