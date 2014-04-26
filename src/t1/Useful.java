package t1;
import java.util.*;

public class Useful {
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void copyArray(int[] A, int[] B){
		for (int i = 0; i < A.length; i++) {
			B[i]=A[i];
		}
	}
	public static int[] extractArray(int[] A,int i,int j){
		int[] ret = new int[j-i+1];
		for (int k = 0; k < ret.length; k++) {
			ret[k] = A[i+k];
		}
		return ret;
	}
	public static void merge(int[] A, int[] B, int first, int last){
		int mid = first + (last - first) / 2;
		for (int i = first; i <= last; i++) {
			B[i] = A[i];
		}
		int i = first;
		int j = mid + 1;
		int k = first;
		while(true){
			if (k > last)
				break;
			if (i > mid && j <= last){
				A[k] = B[j];
				j++;
			}
			else if (j > last && i <= mid){
				A[k] = B[i];
				i++;
			}
			else if (B[i] < B[j]){
				A[k] = B[i];
				i++;
			}
			else{
				A[k] = B[j];
				j++;
				
			}
			k++;
		}
		
	}
	public static void printArrays(int[] A, int[] B){
		System.out.println("Array 1:" + "\t" + "Array2");
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i] + "\t" + B[i]);
		}
	}
	public static void printArray(int[] A){
		System.out.print("[ ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.print("]\n");
	}
	public static int[] generadorAleatorio(int n){
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = i;
		}
		for (int i = 0; i < A.length; i++) {
			swap(A,i,randInt(i,n));
		}
		return A;
	}
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min)) + min;
	    return randomNum;
	}
	public static void main(String[] args) {
		int[] A = {3, 1, 5, 2, 4, 6, 1, 2, 3, 4};
		int[] B = new int[A.length];
		merge(A,B,0,1);
		printArray(A);
	}
}