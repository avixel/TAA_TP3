package app.beans;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import app.data.Account;
import app.interfaces.IBank;


@Component
public class Bank implements IBank {
	
	ArrayList<Account> acc = new ArrayList<Account>() {
		{
			add(new Account("client", 1000));
			add(new Account("store", 5000));
		}
	};
	
	@Override
	public void transfert(double val, String deb, String cred) {
		try {
			getAccount(deb).debit(val);
			getAccount(cred).credit(val);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	private Account getAccount(String n) {
		for(Account a : acc) {
			if(a.getNum().equals(n)) return a;
		}
		return null;
	}

}
