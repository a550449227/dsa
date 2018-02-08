package jl.dsa.algorithm;

/**
 * 线性递归的思想，减而治之；
 * 以冒泡排序；
 * 求数组中非极端数等算法；
 * 二分递归
 * @author cjl
 *
 */
public class AlgorithmDemo1 {
	
	/**
	 * 给定整数子及nums,且|nums| = n>=3
	 * 找出一个数不是最大值也不是最小值
	 * @param nums
	 * @return
	 */
	public int noExtrem(int[] nums){
		int i = nums[0];
		int j = nums[1];
		int k = nums[2];
		if((i<j&&i>k) || (i>j&&i<k) ){
			return i;
		}
		if((j<i&&j>k) || (j>i&&j<k)){
			return j;
		}
		else return k;
	}
	
	/**
	 * 起泡排序,逐趟扫描交换，直到完全有序
	 * @param nums
	 * @return
	 */
	public int[] bubblesort(int[] nums){
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if (nums[i]>nums[j]){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		return nums;
	}
	
	/**
	 * 减而治之，数组求和，线性递归
	 * @param args
	 */
	public int sum(int[] nums,int n){
		if(n < 0){
			return 0;
		}
		return sum(nums,n-1)+nums[n];
		
	}
	
	/**
	 * 使用递归将给定的数组倒置
	 * @param nums
	 * @param hi
	 * @param lo
	 * @return
	 */
	public int[] reverse(int[] nums,int hi,int lo){
		if(lo < hi){	//递归基
			int temp = nums[hi];
			nums[hi] = nums[lo];
			nums[lo] = temp;
			reverse(nums,hi-1,lo+1);
		}
		return nums;
	}
	
	/**
	 * 二分递归，分而治之，递推关系如下
	 * T(n) = 2*T(n/2) + O(1)
	 * 该算法所需时间为 O(n)
	 * @param nums
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int sum1(int[] nums,int lo,int hi){
		if(lo == hi){
			return nums[lo];
		}
		int mi = (lo+hi) >>1;
		return sum1(nums,lo,mi)+sum1(nums, mi+1,hi);
	}
	
	/**
	 * 从数组区间nums[lo,hi)中找出最大等两个整数
	 * 元素的比较次数要求尽可能的少
	 * 采用迭代算法所需时间是θ(2n-3)
	 * 如下是采用二分递归的解法所需时间是5n/3-2
	 * @return
	 */
	public int[] max2(int nums[],int lo,int hi){
		if(lo+2 == hi){
			for(int i=lo;i<hi;i++){
				for(int j=i+1;j<hi+1;j++){
					if (nums[i]<nums[j]){
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					}
				}
			}
			int[] arr = new int[2];
			arr[0] = nums[lo];
			arr[1] = nums[lo+1];
			return arr;
		}
		if(lo+3 == hi){
			for(int i=lo;i<hi;i++){
				for(int j=lo+1;j<hi+1;j++){
					if (nums[i]<nums[j]){
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					}
				}
			}
			int[] arr = new int[2];
			arr[0] = nums[lo];
			arr[1] = nums[lo+1];
			return arr;
		}
		int mi = (lo+hi) >> 1;
		int[] arr1 = max2(nums,lo,mi);
		int[] arr2 = max2(nums,mi+1,hi);
		if(arr1[0]>arr2[0]){
			int[] arr = new int[2];
			arr[0] = arr1[0];
			arr[1] = arr1[1]>arr2[0] ? arr1[1] : arr2[0];
			return arr;
		}else{
			int[] arr = new int[2];
			arr[0] = arr2[0];
			arr[1] = arr2[1]>arr1[0] ? arr2[1] : arr1[0];
			return arr;
		}
	}
	
	/*
	 * 采用递归计算斐波拉契数列
	 * 次算法效率极低,运行时间为O((5/3)^n)呈指数形式增长
	 */
	public long fib1(int n){
		if(n < 2){
			return 1;
		}
		return fib1(n-1)+fib1(n-2);
	}
	
	/**
	 * 采用迭代的方式计算斐波拉契数列的值
	 * 此种算法效率较高
	 * @param n
	 * @return
	 */
	public long fib2(int n){
		int g = 0;
		int f = 1;
		if(n == 0){
			return g;
		}
		if(n ==1){
			return f;
		}
		for(int i = 0;i<n;i++){
			f = f+g;
			g = f-g;
		}
		return f;
	}
	
	/**
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
//		int[] nums = {1,5,7,2,4,9};
		AlgorithmDemo1 ad = new AlgorithmDemo1();
//		int[] arr = ad.max2(nums,0,nums.length-1);
//		System.out.println(sum);
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}
		System.out.println(ad.fib2(6));
	}
	
}
