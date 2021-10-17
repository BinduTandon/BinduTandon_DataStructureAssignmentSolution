package com.gl.Question2;

public class BSTtoSkwedTree {
	
	static Node previous;
	//recursive in order traversal
	static void inOrder(Node current) {
		if(current == null)
			return;
		inOrder(current.left);
		previous.left= null;
		previous.right= current;
		previous = current;
		inOrder(current.right);
		}
	
	static Node rightSkewedTree(Node root) {
		//creating a dummy node and letting it point to node previous
		// in order traversal starts with the dummy
		//at the end of this function we return dummy.right i.e 10
		Node dummy = new Node(-1);
		previous = dummy;
		inOrder(root);
		previous.left= null;
		previous.right = null;
		return dummy.right;
		
	}
	
	static void printTree(Node root) {
		while(root!=null) {
			System.out.println(root.data+" ");
			root = root.right;
			}
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(50);
		root.left= new Node (30);
		root.right = new Node(60);
		root.left.left= new Node(10);
		root.left.right = new Node(40);
		
		printTree(rightSkewedTree(root));
		
	}

}
