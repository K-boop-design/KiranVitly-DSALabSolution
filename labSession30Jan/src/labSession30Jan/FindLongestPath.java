package labSession30Jan;

import java.util.ArrayList;

public class FindLongestPath {
	
	static class Node{
		
		int nodeData;
		Node rightNode;
		Node leftNode;
		
	};
	
	static Node newNode(int data) {
		Node temp=new Node();
		temp.nodeData=data;
		temp.leftNode=null;
		temp.rightNode=null;
		return temp;
	}
	
	public static ArrayList<Integer> findLongestPath(Node root){
		
		if(root==null) {
			ArrayList<Integer> output=new ArrayList<Integer>();
			return output;
		}
		
		ArrayList<Integer> rightNodeList=findLongestPath(root.rightNode);
		ArrayList<Integer> leftNodeList=findLongestPath(root.leftNode);
		
		if(rightNodeList.size()<leftNodeList.size())
			leftNodeList.add(root.nodeData);
		else {
			rightNodeList.add(root.nodeData);
		}
		return leftNodeList.size()>rightNodeList.size()?leftNodeList:rightNodeList;
	}
	public static void main(String[] args) {
		
		Node root=newNode(100);
		root.leftNode=newNode(20);
		root.rightNode=newNode(130);
		root.leftNode.leftNode=newNode(10);
		root.leftNode.rightNode=newNode(50);
		root.rightNode.leftNode=newNode(110);
		root.rightNode.rightNode=newNode(140);
		root.leftNode.leftNode.leftNode=newNode(5);
		ArrayList<Integer> longestPath=findLongestPath(root);
		System.out.println(longestPath);
		

	}

}
