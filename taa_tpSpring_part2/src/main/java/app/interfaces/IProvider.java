package app.interfaces;

import app.data.Item;

public interface IProvider {
	
	// permet de connaitre le prix d'un atricle
	public double getPrice(int id); 
	
	// commande la quantité q de l'article
	public Item order(int id, int q);

}
