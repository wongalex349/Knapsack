

public class Item implements Comparable<Item> {

	private int profit;
	private int weight;
	private float ratio;

	public Item(int w, int p) {
		this.setWeight(w);
		this.setProfit(p);
		this.setRatio();
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio() {
		this.ratio = (float)weight/profit;
	}

	@Override
	public int compareTo(Item other) {
		if (this.ratio > other.getRatio())
			return 1;
		else if (this.ratio < other.getRatio())
			return -1;
		else return 0;
	}
}
