package app.data;

public class Account {
	
	private double money;
	private String num;
	
	public Account(String n, double m) {
		this.num = n;
		this.money = m;
	}
	
	public void credit(double n) {
		money += n;
	}
	public void debit(double n) {
		money -= n;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}
