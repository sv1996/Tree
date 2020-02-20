package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintLevelWise {
	public static TreeNode<Integer> takeInput(){

		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("enter next root data ");
		n=s.nextInt(); // root data
		TreeNode<Integer> root =new TreeNode<Integer>(n);
		System.out.println("enter number of children for " +n);
	     int childCount=s.nextInt();
	  for(int i=0; i< childCount ;i++){
		TreeNode<Integer> child  =takeInput();
		root.children.add(child);
		   }
		return root;
		}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner s =new Scanner(System.in);
		System.out.println("enter root data");
		int rootData=s.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
		TreeNode<Integer> root =new TreeNode<Integer>(rootData);
		 pendingNodes.enqueue(root);
		 while(!pendingNodes.isEmpty()){
			 try {
				TreeNode<Integer> frontNode=pendingNodes.dequeue();
				System.out.println("enter number of children"+frontNode.data);
				int numchildren= s.nextInt();
				for(int i=0;i<numchildren ;i++){
				System.out.println("enter " +(i+1)+"th child of" + frontNode.data  );	
				int child=s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
				
			} catch (QueueEmptyException e) {
				// shoold'nt come here
				 return null;
			}
		 }
		 return root;
	}
//	public static void printLevelWise(TreeNode<Integer> root){
//		 if(root==null){
//			 return ;
//		 }
//		ArrayList<TreeNode<Integer>>  list= new ArrayList<TreeNode<Integer>>();
//		list.add(root);
//		list.add(null);
//		while(list.size()!=0){
//			TreeNode<Integer> currentNode= list.get(0);
//			list.remove(0);
//			if(currentNode==null && list.size()==0){
//				return ;
//			}
//			if(currentNode!=null){
//				System.out.print(currentNode.data +" ");
//				for(int i=0; i<currentNode.children.size();i++){
//					
//					list.add(currentNode.children.get(i));
//					
//				}
////				
////	}
//			if(currentNode==null && list.size()!=0 ){
//				System.out.println();
//				list.add(null);
//			}
//		}
//	}
		 public static void printLevelWise(TreeNode<Integer> root){
			 if(root==null){
				 return ;
			 }
		QueueUsingLL<TreeNode<Integer>> q= new  	QueueUsingLL<TreeNode<Integer>>();
		TreeNode<Integer> nullNode = new 	TreeNode<Integer>(Integer.MIN_VALUE);
		q.enqueue(root);
		q.enqueue(nullNode);
		System.out.println(root.data);
		while(q.size()!=1){
			TreeNode<Integer> temp=null;
			try{
				temp=q.dequeue();
			}
			catch(QueueEmptyException e){
				
			}
		if(temp==nullNode){
			q.enqueue(nullNode);
			System.out.println();
			continue;
		}
			
			for(int i=0; i<temp.children.size();i++){
				System.out.print(temp.children.get(i).data+" ");
				q.enqueue(temp.children.get(i));
			}
			
			
		}
			 
 }
	public static void main(String[] args) {
		TreeNode<Integer> root=takeInputLevelWise();
		printLevelWise(root);
	}

}
