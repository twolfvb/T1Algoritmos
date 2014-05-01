package t1;

public class Sort {
	static double comparaciones;
	
	//BubleSort
	public static int[]  bubbleSort(int[] A){
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length - 1; j++) {
				if (A[j] > A[j+1]){
					Useful.swap(A,j,j+1);
				}
				comparaciones++;
			}
		}
		return A;
	}
	
	
	
	
	//InsertSort
	public static int[] insertSort(int[] A){
	
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j] < A[j-1]) {
					Useful.swap(A,j,j-1);
				}
				comparaciones++;
			}
		}
		return A;
	}
	

	
	//Mergesort
	public static int[] mergeSort(int[] A, int first,int last){
		int sizeLeftArray;
		int sizeRightArray;
		if(last>1){
			sizeLeftArray=last/2;
			sizeRightArray=last-sizeLeftArray;
			mergeSort(A,first,sizeLeftArray);
			mergeSort(A,first+sizeLeftArray,sizeRightArray);
			merge(A,first,sizeLeftArray,sizeRightArray);
		}
		
		return A;
		
		
	}
	
	
	
	public static void merge(int[] A, int first, int sizeL, int sizeR){
		 int[ ] temp = new int[sizeL+sizeR]; 
	      int copiedAtotemp  = 0; 
	      int copiedLtoA = 0; 
	      int copiedRtoA = 0; 
	      int i;          

	      // Merge elements, copying from two halves of data to the temporary array.
	      while ((copiedLtoA < sizeL) && (copiedRtoA < sizeR))
	      {
	    	  
	         if (A[first + copiedLtoA] < A[first + sizeL + copiedRtoA])
	            temp[copiedAtotemp++] = A[first + (copiedLtoA++)];
	         else
	            temp[copiedAtotemp++] = A[first + sizeL + (copiedRtoA++)];
	         comparaciones++;
	      }

	      // Copy any remaining entries in the left and right subarrays.
	      while (copiedLtoA < sizeL)
	         temp[copiedAtotemp++] = A[first + (copiedLtoA++)];
	      while (copiedRtoA < sizeR)
	         temp[copiedAtotemp++] = A[first + sizeL + (copiedRtoA++)];

	      // Copy from temp back to the data array.
	      for (i = 0; i < sizeL+sizeR; i++)
	         A[first + i] = temp[i];
		
	}
	
	
	
	//quickSort
	public static int[] quickSort(int[] A, int first, int last){
		int i = first;
		int j = last;
		int piv = A[last];
		while (i <= j){
			while(A[i] < piv){
				i++;
				comparaciones++;
			}
			while(A[j] > piv){
				j--;
				comparaciones++;
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
		
		return A;
	}	
	public static void main(String[] args) {
		
		int n = 1024;
		int[] A = Useful.generadorAleatorio(n);
		Useful.printArray(A);
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
		mergeSort(A,0,n);
		Useful.printArray(B);
		Useful.printArray(A);
		
		System.out.println("byron weko");
	}
	
}
