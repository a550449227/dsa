package jl.dsa.adt;

/**
 * 二叉查找树简单实现
 * @author cjl
 *
 * @param <AnyType>
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	private static class BinaryNode<AnyType>{
		
		BinaryNode(AnyType theElement){
			this(theElement,null,null);
		}
		BinaryNode(AnyType theElement,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
			element = theElement;
			left = lt;
			right = rt;
			
		}
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
	}
	
	private BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root = null;
	}
	public void makeEmpty(){
		root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean contains(AnyType x){
		return contains(x,root);
	}
	
	public AnyType findMin(){
		if(isEmpty()){
			throw new NullPointerException();
		}
		return findMin(root).element;
	}
	public AnyType findMax(){
		if(isEmpty()){
			throw new NullPointerException();
		}
		return findMax(root).element;
	}
	
	public void insert(AnyType x){
		
		root = insert(x,root);
	}
	
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(t == null){
			return null;
		}else if(t.left == null){
			return t;
		}
		return findMin(t.left);
	}
	
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(t != null){
			while(t.right != null){
				t = t.right;
			}
		}
		return t;
	}
	
	private boolean contains(AnyType x, BinaryNode<AnyType> t){
		if(t == null){
			return false;
		}
		int compareResult = x.compareTo(t.element);
		if(compareResult<0){
			return contains(x,t.left);
		}else if(compareResult>0){
			return contains(x,t.right);
		}else{
			return true;
		}
	}
	
	private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
		if(t == null){
			return new BinaryNode<AnyType>(x,null,null);
		}
		int compareResult = x.compareTo(t.element);
		if(compareResult<0){
			t.left = insert(x,t.left);
		}else if(compareResult>0){
			t.right = insert(x,t.right);
		}else{
		}
		return t;
	}
	
	private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
		if(t == null){
			return t;
		}
		int compareReslt = x.compareTo(t.element);
		if(compareReslt<0){
			t.left = remove(x,t.left);
		}else if(compareReslt>0){
			t.right = remove(x, t.right);
		}else if(t.left!=null && t.right!=null){
			t.element = findMin(t.right).element;
			t.right = remove(t.element,t.right);
		}
		return t;
	}
	
	
}
