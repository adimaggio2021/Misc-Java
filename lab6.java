import java.util.*;
import java.io.*;

public class lab6 {
	public static Comparable[] merge(Comparable[] ar1, Comparable[] ar2) {
		Comparable[] result = new Comparable[ar1.length+ar2.length];
		int start1 = 0;
		int start2 = 0;
		int nextadd = 0;
		while(start1< ar1.length && start2 < ar2.length) {
			if(ar1[start1].compareTo(ar2[start2])< 0) {
				result[nextadd] = ar1[start1];
				start1++;
				nextadd++;
			}else {
				result[nextadd] = ar2[start2];
				start2++;
				nextadd++;
			}
		}
		if(start1 < ar1.length) {
			for(int i = start1;i<ar1.length;i++) {
				result[nextadd] = ar1[i];
				nextadd++;
			}
		}else {
			for(int i = start2;i<ar2.length;i++) {
				result[nextadd] = ar2[i];
				nextadd++;
			}
		}
		return result;
		
	}
	
	public static Comparable[] mergesort(Comparable[] ar) {
		if(ar.length == 1) {
			return ar;
		}
		return merge(mergesort(copyArr(ar,0,ar.length/2)),mergesort(copyArr(ar,ar.length/2,ar.length)));
	}
	
	    //read file
	    public static Comparable[][] readArrays(String fileName){
		Comparable[][] arr = new Comparable[10][10];
		try{
		    File f = new File(fileName);
		    Scanner in = new Scanner(f);
		    for (int i = 0; i < 10; i++){
			String[] r = in.next().split(",");
			for (int j = 0; j < 10; j++){
			    arr[i][j] = (Comparable)r[j];
			}
		    }
		}
		catch (Exception e){
		    System.out.println(e);
		}	
		return arr;
	    }
	    
	    //inclusive of start, exclusive of stop
	    public static Comparable[] copyArr(Comparable[] a, int start, int stop){
		Comparable[] copy = new Comparable[stop-start];
		for (int i = start, j = 0; i < stop && j < stop - start; i++, j++){
		    copy[j] = a[i];
		}
		return copy;
	    }
	    
	    public static void quicksort(Comparable[] ar, int lo, int hi) {
	    	if(lo < hi) {
	    	int tot = partition(ar, lo, hi);
	    	quicksort(ar,lo,tot-1);
	    	quicksort(ar,tot+1,hi);
	    	}
	    }
	    
	    
	    public static int partition(Comparable[] ar, int lo, int hi){
	    	Comparable pivot = ar[hi];
	    	 int i = (lo-1); 
	         for (int j=lo; j<hi; j++) { 
	             if (ar[j].compareTo(pivot)<=0){ 
	                 i++;
	                 Comparable temp = ar[i]; 
	                 ar[i] = ar[j]; 
	                 ar[j] = temp; 
	             } 
	         }
	         Comparable temp = ar[i+1]; 
	         ar[i+1] = ar[hi]; 
	         ar[hi] = temp; 
	   
	         return i+1; 
 	    }
	   public static void main(String[] args) {
		   Scanner in = new Scanner(System.in);
		   System.out.println("Input filename.");
		   String s = in.nextLine();
		   Comparable [][] store = readArrays(s);
		   for(Comparable [] x : store) {
			   for(Comparable y : x) {
				   System.out.print(y);
				   System.out.print(" ");
			   }
			   System.out.println();
		   }
		   System.out.println("");
		   for(Comparable [] x : store) {
			   quicksort(x,0,x.length-1);
			   for(Comparable y : x) {
				   System.out.print(y);
				   System.out.print(" ");
			   }
			   System.out.println();
		   }
	   }
}
