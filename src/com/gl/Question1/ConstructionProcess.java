package com.gl.Question1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructionProcess {
	Queue<Integer> queue = new LinkedList<>();
	Queue<Integer>tempQueue = new LinkedList<>();
	Queue<Integer>waitQueue = new LinkedList<>();

	public void addEle(int data) {
		queue.add(data);
	}
	public void push(int data) {
		if (tempQueue.size()==0)
		{

			tempQueue.add(data);
		}
		else {	
			//tempqueue converted into stack
			while (tempQueue.size() >0)
				waitQueue.add(tempQueue.remove());

			tempQueue.add(data);

			while (waitQueue.size()>0)
				tempQueue.add(waitQueue.remove());
		}
	}
	public void orderOfConstruction(int size) {
		int max = size;
		System.out.println("\nThe order of construction is as follows :");
		for (int i = 1; i<= size; i++) {
			if(queue.peek()==max) {
				System.out.println("\nDay "+(i));
				System.out.print(queue.peek()+ " ");
				queue.remove();
				max--;
				if(tempQueue.peek()!=null) {
					while(tempQueue.size()>0){
						if(tempQueue.peek()==max) {
							System.out.print(tempQueue.peek()+ " ");
							tempQueue.remove();
							max--;
						}
						else {
							waitQueue.add(tempQueue.remove());
						}
					}
				}
			}
			else{
				System.out.println("\nDay "+(i));
				System.out.println();
				push(queue.remove());
			}
		}
		while(waitQueue.size()>0) {
			tempQueue.add(waitQueue.remove());
			while(tempQueue.size()>0){
				if(tempQueue.peek()==max) {
					System.out.print(tempQueue.peek()+ " ");
					tempQueue.remove();
					max--;
				}
				else {
					waitQueue.add(tempQueue.remove());
					tempQueue.add(waitQueue.remove());
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConstructionProcess construction = new ConstructionProcess();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building ");
		int floors = sc.nextInt();
		for (int i=0; i<floors;i++) {
			System.out.println("Enter the floor size given on day " +(i+1));
			int floorsize = sc.nextInt();
			construction.addEle(floorsize);
		}
		construction.orderOfConstruction(floors);
		sc.close();
	}
}