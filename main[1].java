import java.util.*;

public class main {

	private static int[] w;
	private static int[] p;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter array size: "); //prompting size of array
		int n = scan.nextInt();
		w = new int[n];
		p = new int[n];
		int weight[] = new int[n];
		int profit[] = new int[n];
		int x = 1;
        for(int i = 0; i < weight.length; i++) //asking for list of weights
        {
            System.out.print("Enter weight for item " + x + ": ");
            weight[i] = scan.nextInt();
            x++;
        }
        x = 1;
        for(int i = 0; i < profit.length; i++) // asking for list of profits for the given weights
        {
            System.out.print("Enter profit for item " + x + "(weight = " + weight[i] + "): ");
            profit[i] = scan.nextInt();
            x++;
        }
        sort(weight,profit);
        System.out.print("Enter max weight: "); //enter the max weight to knapsack
        int max = scan.nextInt();
        System.out.println("----------------------------------------"); //prints out the weights with its profits so its clear what the table is
        System.out.print("Weight: ");
        for(int i = 0; i < n; i++)
            System.out.print(weight[i] + "\t");
        System.out.print("\nProfit: ");
        for(int i = 0; i < n ; i++)
            System.out.print(profit[i] + "\t");
        System.out.println();
        System.out.println("----------------------------------------");

        System.out.println("\nBrute Force: "); //Brute force algorithm
        BruteForce bf = new BruteForce();
        bf.n = n;
        bf.include = new int[n];
        bf.bestset = new int[n];
        bf.knapsackBF(-1,0,0,n,p,w,max);
        System.out.println("Weight = " + Arrays.toString(w));
        System.out.println("Profit = " + Arrays.toString(p));
        System.out.print("Items Taken =  ");
        for(int i=0; i < bf.bestset.length; i++) {
            if(bf.bestset[i] == 1) {
                System.out.print(" $" + profit[i]);
            }
            else
                continue;
        }
        System.out.println();
        System.out.println("Max Profit = $" + bf.maxProfit);
        System.out.println("Nodes Visited = " + bf.count);
        System.out.println("----------------------------------------");
        System.out.println("Backtrack: ");  //backtracking algorithm
        Backtrack bt = new Backtrack();
        bt.n = n;
        bt.include = new int[n];
        bt.bestset = new int[n];
        bt.knapsack(-1,0,0,n,p,w,max);
        System.out.println("Weight =  " + Arrays.toString(w));
        System.out.println("Profit = " + Arrays.toString(p));
        System.out.print("Items Taken =  ");
        for(int i=0; i < bt.bestset.length; i++) {
            if(bt.bestset[i] == 1) {
                System.out.print(" $" + profit[i]);
            }
            else
                continue;
        }
        System.out.println();
        System.out.println("MaxProfit =  $" + bt.maxProfit);
        System.out.println("Nodes Visited =  " + bt.count);
        System.out.println("----------------------------------------");
        System.out.println("Branch and Bound: ");

        BranchandBound bnb = new BranchandBound();  //branch and bound algorithm
        bnb.knapsack(n,p,w,max);
        System.out.println("Weight = " + Arrays.toString(w));
        System.out.println("Profit = " + Arrays.toString(p));
        System.out.println("Max Profit = $" + bnb.maxProfit);
        System.out.println("Nodes Visited = " + bnb.count);

        System.out.println("----------------------------------------");

	}
	
	public static void sort(int[] wInput, int[] pInput ) {  //sorting it so the best ratio is given
		ArrayList<Item> itemsTaken = new ArrayList<Item>();
		for(int i = 0; i < wInput.length; i++) {
			Item item = new Item(wInput[i], pInput[i]);
			itemsTaken.add(item);
		}
		Collections.sort(itemsTaken);
		for(int i = 0; i < itemsTaken.size(); i++ ) {
			p[i] = itemsTaken.get(i).getProfit();
			w[i] = itemsTaken.get(i).getWeight();
		}
		
	}
}
