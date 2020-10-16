package app.interfaces;

public interface IBank {
	
	// permet le transfert d'argent x entre 2 comptes
	public void transfert(double val, String deb, String cred);

}
