package app.interfaces;

// permet achats avec remplissage panier
// et paiement a la sortie
public interface ILane{
	
	// ajout article au "panier" d'une quantité q
	public void addItemToCart(int id, int q);
	
	// paiement
	public void pay(String cb);

}
