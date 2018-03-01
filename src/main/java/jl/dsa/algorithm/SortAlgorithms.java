package jl.dsa.algorithm;

/**
 * 各种排序算法的实现
 * @author cjl
 *
 */
public class SortAlgorithms {
	
	/**
	 * 插入排序
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> 
	void insertionSort(AnyType[] a){
		int j;
		for(int p = 1; p < a.length; p++){
			AnyType tmp = a[p];
			for(j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--){
				a[j] = a[j-1];
			}
			a[j] = tmp;
		}
	}
	
	/**
	 * 希尔排序
	 * 使用希尔增量
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType [] a){
		int j;
		for(int gap = a.length/2; gap>0; gap/=2){
			for(int i = gap; i < a.length; i++){
				AnyType tmp = a[i];
				for(j = i; j >= gap && tmp.compareTo(a[j-gap]) < 0; j -= gap){
					a[j] = a[j-gap];
				}
				a[j] = tmp;
			}
		}
	}
	
	/**
	 * 堆排序
	 * @param a
	 */
	public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a){
		for(int i = a.length/2-1; i >= 0; i--){
			percDown(a, i, a.length);
		}
		for(int i = a.length-1; i>0; i--){
			swap(a, 0, i);
			percDown(a, 0, i);
		}
		
	}
	
	
	private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a, int i, int n){
		int child;
		AnyType tmp;
		for(tmp = a[i]; leftChild(i) < n; i = child){
			child = leftChild(i);
			if(child != n-1 && a[child].compareTo(a[child+1])<0){
				child++;
			}
			if(tmp.compareTo(a[child]) < 0){
				a[i] = a[child];
			}else{
				break;
			}
		}
		a[i] = tmp;
	}
	
	private static int leftChild(int i){
		return 2*i + 1;
	}
	
	private static <AnyType> void swap(AnyType[] arr, int idx1, int idx2){
		AnyType tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
		
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{9,8,7,6,5,4,3,2,1};
		heapSort(arr);
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}
	
}
