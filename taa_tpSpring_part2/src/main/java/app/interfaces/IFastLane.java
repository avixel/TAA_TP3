package app.interfaces;

public interface IFastLane{
	
	// commande un article id d'un certaine quantité q
	//	et régler direct
	public void oneShotOrder(int id, int q, String n);

}
