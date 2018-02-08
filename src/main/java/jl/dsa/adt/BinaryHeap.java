package jl.dsa.adt;

import java.util.NoSuchElementException;

/**
 * 实现优先队列的一种方法：使用二叉堆，BinaryHeap
 * @author cjl
 *
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
	private static final int DEFAULT_CAPACITY = 10;
	private int currentSize;
	private AnyType[] array;
	public BinaryHeap(){
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	private BinaryHeap(int capacity){
		currentSize = 0;
		array = (AnyType[]) new Comparable[capacity+1];
	}
	@SuppressWarnings("unchecked")
	public BinaryHeap(AnyType[] items){
		currentSize = items.length;
		array = (AnyType[]) new Comparable[(currentSize+2)*11/10];
		int i = 1;
		for(AnyType item : items){
			array[i++] = item;
		}
		buildHeap();
	}
	
	/**
	 * 从任意排列堆项目中建立堆
	 */
	private void buildHeap(){
		for(int i = currentSize/2; i>0 ;i--){
			percolateDown(i);
		}
	}
	
	/**
	 * 堆内元素下移
	 * @param hole
	 */
	private void percolateDown(int hole){
		int child;
		AnyType tmp = array[hole];
		for(; hole*2<=currentSize;hole = child){
			child = hole * 2;
			if(child != currentSize && array[child+1].compareTo(tmp)<0){
				array[hole] = array[child];
			} else {
				break;
			}
		}
		array[hole] = tmp;
	}
	
	/**
	 * 插入元素
	 * @param x
	 */
	public void insert(AnyType x){
		if(isFull()){
			enlargeArray(array.length*2 + 1);
		}
		int hole = ++currentSize;
		for(; hole>1 && x.compareTo(array[hole/2])<0;hole/=2){
			array[hole] = array[hole/2];
		}
		array[hole] = x;
	}
	
	/**
	 * 堆是否满
	 * @return
	 */
	public boolean isFull(){
		return currentSize == array.length-1;
	}
	
	/**
	 * 堆是否空
	 * @return
	 */
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	/**
	 * 清空堆
	 */
	@SuppressWarnings("unused")
	public void makeEmpty(){
		currentSize = 0;
		for(AnyType t: array){
			t = null;
		}
	}
	
	/**
	 * 找到堆中堆最小元素
	 * @return
	 */
	public AnyType findMin(){
		if(isEmpty()){
			return null;
		}
		return array[1];
	}
	
	/**
	 * 删除堆中最小元素
	 * @return
	 */
	public AnyType deleteMin() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		AnyType minItem = findMin();
		array[1] = array[currentSize];
		array[currentSize--] = null;
		percolateDown(1);
		return  minItem;
	}
	
	
	@SuppressWarnings("unchecked")
	private void enlargeArray(int newSize){
		AnyType[] old = array;
		array = (AnyType[]) new Comparable[newSize];
		for(int i = 0; i<old.length; i++){
			array[i] = old[i];
		}
	}
	
	public void printHeap(){
		for(AnyType t: array){
			System.out.println(t + " ");
		}
	}
	
	
}
