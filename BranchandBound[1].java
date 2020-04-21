import java.util.*;

public class BranchandBound {
	public class Node implements Comparable<Node> {
		 int level, profit, weight;
		 float bound;

		@Override
		public int compareTo(Node other) {
			if (this.bound < other.bound)
				return 1;
			 else if (this.bound > other.bound)
				return -1;
			else return 0;
		}
	}
	
	int j, k, total, W, n;
	int[] w = new int [n];
	int[] p = new int [n];

	float result;
	public int maxProfit;
	public int count=0;
	
	public void knapsack (int n, int p[], int w[], int W) {

		PriorityQueue<Node> PQ = new PriorityQueue<>();
		Node u = new Node();
		Node v = new Node();

		this.W = W;
		this.n = n;
		this.w = w;
		this.p = p;

		v.level = -1;
		v.profit = 0;
		v.weight = 0;
		this.maxProfit=0;

		v.bound = bound(v);
		PQ.add(v);
		while (!PQ.isEmpty()) {
			
			v = PQ.remove();

			if (v.bound > maxProfit) {

				u = new Node();
				u.level = v.level + 1;

				u.weight = v.weight + w[u.level];

				u.profit = v.profit + p[u.level];
				u.bound = bound(u);
				if (u.weight <= W && u.profit > maxProfit){

					maxProfit = u.profit;
				}
				if (u.bound > maxProfit) {
					PQ.add(u);
				}

				u = new Node();
				u.level = v.level + 1;
				u.weight = v.weight;

				u.profit = v.profit;
				u.bound = bound(u);
				if (u.bound > maxProfit) {

					PQ.add(u);
				}
			}
			
		}
		
	}

	public float bound(Node u) {
		count++;

		if (u.weight >= W)
			return 0;

		else {
			result = u.profit;
			j = u.level + 1;

			total = u.weight;
			while (j < n && total + w[j] <= W) {
				total = total + w[j];
				result = result + p[j];
				j++;
			}
		}
		k = j;
		if (k < n) {
			result = result + (W - total) * p[k] / w[k];
		}

		return result;
	}
}
