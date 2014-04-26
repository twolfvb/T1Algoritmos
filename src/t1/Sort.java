package t1;

public class Sort {
	public static void bubbleSort(int[] A){
		int counter = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length - 1; j++) {
				if (A[j] > A[j+1]){
					Useful.swap(A,j,j+1);
				}
				counter++;
			}
		}
		System.out.println(counter);
	}
	public static void insertSort(int[] A){
		int counter = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j] < A[j-1]) {
					Useful.swap(A,j,j-1);
				}
				counter++;
			}
		}
		System.out.println(counter);
	}
	public static void mergeSort(int[] A, int[] B, int first, int last){
		if (last > first){
			int mid = first + (last - first)/2;
			Useful.printArray(A);
			mergeSort(A,B,first,mid);
			mergeSort(A,B,mid+1,last);
			Useful.merge(A, B, first, last);
		}
	}
	
	public static void quickSort(int[] A, int first, int last){
		int i = first;
		int j = last;
		int piv = A[last];
		while (i <= j){
			while(A[i] < piv){
				i++;
			}
			while(A[j] > piv){
				j--;
			}
			if (i <= j){
				Useful.swap(A,i,j);
				i++;
				j--;
			}
		}
		if (first < j)
			quickSort(A,first,j);
		if (i < last)
			quickSort(A,i,last);
	}	
	public static void main(String[] args) {
		/*
		int n = 1024;
		int[] A = Useful.generadorAleatorio(n);
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		int[] E = new int[n];
		Useful.copyArray(A, B);
		Useful.copyArray(A, C);
		Useful.copyArray(A, D);
		Useful.copyArray(A, E);
		Useful.printArray(B);
		bubbleSort(B);
		insertSort(C);
		Useful.printArray(B);
		*/
		System.out.println("byron weko");
	}
	
}
