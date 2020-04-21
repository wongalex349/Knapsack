import java.util.*;

public class Backtrack {
	public int W, maxProfit=0,   n;
	
	public int i, profit, weight;
	public int[] include;
	public int[] bestset;

	public int[] w = new int [n];
	public int[] p = new int [n];
	public int count = 0;

	public int numBest;

	
	public void knapsack (int i, int profit, int weight,int n, int p[], int w[], int W)
	{

		this.W = W;
		this.n = n;
		this.w = w;
		this.p = p;

		if (weight <= W && profit > maxProfit)
		{

			maxProfit = profit;
			int numBest = i;
			
			bestset =include.clone();

		}
		if (promising(i, profit, weight) == true)
		{

				include[i+1] = 1;
				
				knapsack(i + 1, profit + p[i + 1], weight + w[i + 1], n, p, w, W);
				include[i +1] = 0;
				
				knapsack(i + 1, profit, weight, n, p, w, W);	
					
		}

	}
	public boolean promising (int i, int profit, int weight) {
		int j, k, totweight;
		double bound;
		
		count++;

		if (weight >= W)
			return false;
		else {
			j = i + 1;
			bound = profit;
			totweight = weight;

			
			while (j < n && totweight + w[j] <= W) {
				totweight = totweight + w[j];
				bound = bound + p[j];
				j++;
			}
			k = j;
			if (k < n) {
				bound = bound + (W - totweight) * p[k]/w[k];
				
			}

			return bound > maxProfit;
			
		}
		
	}


}
