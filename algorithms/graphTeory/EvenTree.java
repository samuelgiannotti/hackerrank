package hackerhank.algorithms.graphTeory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EvenTree {

	  public static int countVertices(int root, HashMap<Integer,ArrayList<Integer>> t){
	        if(!t.containsKey(root)){
	            return 1;
	        }
	        int v=1;
	        for(int i : t.get(root)){
	            int c = countVertices(i,t);
	            if(c%2==0){
	                t.get(-1).set(0,t.get(-1).get(0)+1);
	            }
	            v+=c;
	        }
	        return v;
	    }  
	
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int v = in.nextInt();
	        int e = in.nextInt();
	        
	        HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
	        
	        for(int i=0; i<e; i++){
	            int f = in.nextInt();
	            int n = in.nextInt();
	            if(tree.containsKey(n)) {          
	            	tree.get(n).add(f);
	            } else{
	                ArrayList<Integer> a = new ArrayList<>();
	                a.add(f);
	                tree.put(n,a);
	            }
	        }
	        
	        ArrayList<Integer> n = new ArrayList<Integer>();
	        n.add(0);
	        tree.put(-1,n);
	        int w = countVertices(1,tree);
	        System.out.println(tree.get(-1).get(0));       
	        
	    }
}
