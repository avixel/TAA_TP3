package app.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.interfaces.IRun;
import app.interfaces.IStore;

@Component
public class Client implements IRun{
	
	@Autowired
	IStore is;
	
	String num = "client";

	@Override
	public void run() {
		// test fastLane
		System.out.println("\nOne shot order:");
		is.oneShotOrder(0, 10, num);
		// test justHaveALook
		System.out.println("\nJustHaveALook:");
		is.isAvailable(0, 1);
		// test Lane
		System.out.println("\nLane:");
		is.isAvailable(1, 10);
		is.addItemToCart(1, 5);
		is.addItemToCart(2, 6);
		is.pay("client");
		is.isAvailable(1, 5);
		is.isAvailable(1, 6);
	}

}
