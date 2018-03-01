package jl.dsa.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速排序
 * @author cjl
 *
 */
public class QuickSort {
	public static void sort(List<Integer> items){
		if(items.size() > 1){
			List<Integer> smaller = new ArrayList<Integer>();
			List<Integer> same = new ArrayList<Integer>();
			List<Integer> lager = new ArrayList<Integer>();
			
			Integer chosenItem = items.get(items.size()/2);
			
			for (Integer i : items) {
				if(i < chosenItem){
					smaller.add(i);
				}else if(i > chosenItem){
					lager.add(i);
				}else{
					same.add(i);
				}
			}
			sort(smaller);
			sort(lager);
			
			items.clear();
			items.addAll(smaller);
			items.addAll(same);
			items.addAll(lager);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> items = new ArrayList<Integer>();
		items.add(6);
		items.add(5);
		items.add(6);
		items.add(4);
		items.add(9);
		items.add(8);
		items.add(3);
		items.add(7);
		sort(items);
		System.out.println(items);
	}
	
}
