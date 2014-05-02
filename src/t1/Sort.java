package t1;

public class Sort {
	static long comparaciones;
	
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
		
		comparaciones = 0;
		long start;
		long end;
		long microseconds;
		long[] insComp = new long[11];
		long[] insTime = new long[11];
		long[] bubComp = new long[11];
		long[] bubTime = new long[11];
		long[] merComp = new long[11];
		long[] merTime = new long[11];
		long[] quiComp = new long[11];
		long[] quiTime = new long[11];
		
		for (int i = 10; i < 21; i++) {
			int t = (int)Math.pow(2, i);
			int[] A = Useful.generadorCasiOrdenado(t, 5);
			int[] B = new int[t];
			int[] C = new int[t];
			int[] D = new int[t];
			Useful.copyArray(A, B);
			Useful.copyArray(A, C);
			Useful.copyArray(A, D);
			
			comparaciones = 0;
			start = System.nanoTime();
			insertSort(A);
			end = System.nanoTime();
			microseconds = (end - start) / 1000;
			insComp[i-10]=comparaciones;
			insTime[i-10]=microseconds;
			
			comparaciones = 0;
			start = System.nanoTime();
			bubbleSort(B);
			end = System.nanoTime();
			microseconds = (end - start) / 1000;
			bubComp[i-10]=comparaciones;
			bubTime[i-10]=microseconds;
			
			comparaciones = 0;
			start = System.nanoTime();
			mergeSort(C, 0, t);
			end = System.nanoTime();
			microseconds = (end - start) / 1000;
			merComp[i-10]=comparaciones;
			merTime[i-10]=microseconds;
			
			comparaciones = 0;
			start = System.nanoTime();
			quickSort(D,0,t-1);
			end = System.nanoTime();
			microseconds = (end - start) / 1000;
			quiComp[i-10]=comparaciones;
			quiTime[i-10]=microseconds;
			
			System.out.println(i);	
		}
		System.out.println("comparations taken, insert bubble merge quick");
		Useful.printArray(insComp);
		Useful.printArray(bubComp);
		Useful.printArray(merComp);
		Useful.printArray(quiComp);
		
		System.out.println("time taken, insert bubble merge quick");
		Useful.printArray(insTime);
		Useful.printArray(bubTime);
		Useful.printArray(merTime);
		Useful.printArray(quiTime);
		
	}
}
