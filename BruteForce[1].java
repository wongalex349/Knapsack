
import java.util.*;

public class BruteForce {
	public int W, maxProfit=0,   n;

	public int i, profit, weight;
	public int[] include;
	public int[] bestset;


	public int[] w = new int [n];
	public int[] p = new int [n];
	public int count = 0;

	public int numBest;



	public void knapsackBF (int i, int profit, int weight,int n, int p[], int w[], int W)
	{
		count++;


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
		if (i == n-1 ) {
			return;
		}
		include[i+1] = 1;
		
		knapsackBF(i + 1, profit + p[i + 1], weight + w[i + 1], n, p, w, W);
		include[i +1] = 0;
		
		knapsackBF(i + 1, profit, weight, n, p, w, W);	


	}
}

