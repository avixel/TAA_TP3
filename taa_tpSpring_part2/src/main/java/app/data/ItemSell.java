package app.data;

public class ItemSell extends Item{
	
	int qtt;

	public ItemSell(int i, double p, int q) {
		super(i, p);
		this.qtt = q;
	}
	
	public void dec(int n) {
		qtt -= n;
	}
	public void inc(int n) {
		qtt += n;
	}

	public int getQtt() {
		return qtt;
	}

	public void setQtt(int qtt) {
		this.qtt = qtt;
	}

}
