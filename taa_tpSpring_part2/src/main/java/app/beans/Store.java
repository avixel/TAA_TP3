package app.beans;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.data.ItemSell;
import app.interfaces.IBank;
import app.interfaces.IProvider;
import app.interfaces.IStore;

@Component
public class Store implements IStore{
	
	@Autowired
	IBank bank;
	@Autowired
	IProvider prov;
	
	String num = "store";
	
	ArrayList<ItemSell> items = new ArrayList<ItemSell>() {
		{
			add(new ItemSell(0, 10.0, 10));
			add(new ItemSell(1, 21.0, 10));
			add(new ItemSell(2, 30.1, 10));
		}
	};
	
	ArrayList<ItemSell> cart = new ArrayList<ItemSell>();

	@Override
	public void oneShotOrder(int id, int q, String n) {
		addItemToCart(id, q);
		pay(n);
	}

	@Override
	public double getPrice(int id) {
		return findItemSell(id).getPrice();
	}

	@Override
	public boolean isAvailable(int id, int q) {
		if(q <= findItemSell(id).getQtt()) {
			System.out.println("Item "+id+" available x"+q);
			return true;
		} else {
			System.out.println("Item "+id+" not available x"+q);
			return false;
		}
	}

	@Override
	public void addItemToCart(int id, int q) {
		if(isAvailable(id, q)) {
			System.out.println("Took item "+id +" x"+q+" (will cost "+findItemSell(id).getPrice()*q+"$)");
			cart.add(new ItemSell(id, findItemSell(id).getPrice(), q));
		} else {
			System.out.println("Did not took the item "+id+" x"+q);
		}
	}

	@Override
	public void pay(String cb) {
		double p = 0.0;
		for(ItemSell i : cart) {
			findItemSell(i.getId()).dec(i.getQtt());
			p += i.getPrice()*i.getQtt();
		}
		System.out.println("Pay "+p+"$");
		bank.transfert(p, cb, this.num);		
	}
	
	private ItemSell findItemSell(int id) {
		for(ItemSell i : items) {
			if(i.getId() == id) return i;
		}
		return null;
	}
	
}
