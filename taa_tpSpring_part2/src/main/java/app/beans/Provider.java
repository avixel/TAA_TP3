package app.beans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import app.data.Item;
import app.data.ItemSell;
import app.interfaces.IProvider;

@Component
public class Provider implements IProvider{
	
	ArrayList<Item> items = new ArrayList<Item>(){
		{
			add(new Item(0, 10.0));
			add(new Item(1, 21.0));
			add(new Item(2, 30.1));
		}
	};
	
	@Override
	public double getPrice(int id) {
		return findItem(id).getPrice();
	}

	@Override
	public Item order(int id, int q) {
		return new ItemSell(id, findItem(id).getPrice(), q);
	}
	
	private Item findItem(int id) {
		for(Item i : items) {
			if(i.getId() == id) return i;
		}
		return null;
	}

}
