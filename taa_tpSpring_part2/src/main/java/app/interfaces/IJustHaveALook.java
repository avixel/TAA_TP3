package app.interfaces;

public interface IJustHaveALook{
	
	// retourne prix d'un article
	public double getPrice(int id);
	
	// permet de savoir si l'article est dispo en une quantité q
	public boolean isAvailable(int id, int q);

}
