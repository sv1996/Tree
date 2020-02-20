package trees;
import java.util.*;
public class TreeUse {
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

public static void print(TreeNode<Integer> root){
	String s = root.data +":";
	for(int i=0; i<root.children.size();i++){
		s= s+ root.children.get(i).data +",";
		
		
		
	}
	System.out.println(s);	
	for(int i=0; i<root.children.size();i++){
		print(root.children.get(i));
	}
}



	public static void main(String[] args) {
		TreeNode<Integer> root=takeInput();
		print(root);
		
		
//	 TreeNode<Integer> root= new TreeNode<Integer> (4);
//	 TreeNode<Integer> node1= new TreeNode<Integer> (2);
//	 TreeNode<Integer> node2= new TreeNode<Integer> (3);
//	 TreeNode<Integer> node3= new TreeNode<Integer> (5);
//	 TreeNode<Integer> node4= new TreeNode<Integer> (6);
//	 root.children.add(node1);
//	 root.children.add(node2);
//	 root.children.add(node3);
//	 // now add 3 to 6 that is 3's child
//	 node2.children.add(node4);
//	 System.out.println(root);
//	 
	 
	 
	}

}
