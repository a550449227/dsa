package jl.dsa.adt;

import java.util.LinkedList;
import java.util.List;
/**
 * 使用分离链接法实现的简单hashtable
 * @author cjl
 *
 * @param <AnyType>
 */
public class SeparateChainingHashTable<AnyType>{
	private static final int DEFAULT_TABLE_SIZE = 10;
	private List<AnyType>[] theLists;
	private int currentSize;
	
	public SeparateChainingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
	
	public SeparateChainingHashTable(int size){
		theLists = new LinkedList[nextPrime(size)];
		for(int i = 0; i < theLists.length;i++){
			
			theLists[i] = new LinkedList<AnyType>();
		}
	}
	
	private void makeEmpty(){
		for(List<AnyType> list:theLists){
			list.clear();
		}
		currentSize = 0;
	}
	
	public boolean contains(AnyType x){
		List<AnyType> whichList = theLists[myHash(x)];
		return whichList.contains(x);
	}
	
	public void insert(AnyType x){
		List<AnyType> whichList = theLists[myHash(x)];
		if(!whichList.contains(x)){
			whichList.add(x);
			if(++currentSize > theLists.length){
				rehash();
			}
		}
		
	}
	public void remove(AnyType x){
		List<AnyType> whichList = theLists[myHash(x)];
		if(whichList.contains(x)){
			whichList.remove(x);
			currentSize--;
		}
	}
	
	
	private void rehash(){
		List<AnyType>[] oldLists = theLists;
		theLists = new List[nextPrime(2*theLists.length)];
		for(int j = 0;j<theLists.length; j++ ){
			theLists[j] = new LinkedList<AnyType>();
		}
		currentSize = 0;
		for(int i = 0;i<oldLists.length;i++){
			for(AnyType item:oldLists[i]){
				insert(item);
			}
		}
	}
	
	private int myHash(AnyType x){
		int hashVal = x.hashCode();
		hashVal %= theLists.length;
		if(hashVal<0){
			hashVal += theLists.length;
		}
		return hashVal;
	}
	
	private static boolean isPrime(int num){
		if(num ==2 || num == 3){
			return true;
		}
		if(num == 1 || num%2 == 0){
			return false;
		}
		for(int i = 3; i*i<num; i+=2){	
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	
	
	private static int nextPrime(int num){
		if(num == 0 || num == 1 || num == 2){
			return 2;
		}
		
		if(num%2 == 0){
			num++;
		}
		while(!isPrime(num)	){
			num += 2;
		}
		return num;
	}
}