package jl.dsa.algorithm;

/**
 * 归并排序的实现
 * @author cjl
 *
 */
public class MergeSort {
	private static <AnyType extends Comparable<?super AnyType>> void merge(AnyType[] a, AnyType[] tmpArray,
			int leftPos, int rightPos, int rightEnd){
		int leftEnd = rightPos-1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(a[leftPos].compareTo(a[rightPos]) <= 0){
				tmpArray[tmpPos++] = a[leftPos++];
			}else{
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		
		while(leftPos <= leftEnd){
			tmpArray[tmpPos++] = a[leftPos++];
		}
		while(rightPos <= rightEnd){
			tmpArray[tmpPos++] = a[rightPos++];
		}
		
		for(int i = 0; i < numElements; i++, rightEnd--){
			a[rightEnd] = tmpArray[rightEnd];
		}
	}
	
	private static <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a, AnyType[] tmpArray,int left,int right){
		if(left < right){
			int center = (left + right)/2;
			sort(a,tmpArray,left,center);
			sort(a,tmpArray,center+1,right);
			merge(a, tmpArray, left, center+1, right);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <AnyType extends Comparable<? super AnyType>>void sort(AnyType[] a){
		AnyType[] tmpArray = (AnyType[])new Comparable[a.length];
		sort(a,tmpArray,0,a.length-1);
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{7,8,9,2,3,5,6,1};
		sort(arr);
		for (Integer integer : arr) {
			System.out.print(integer + " ");
		}
	}
	
}
