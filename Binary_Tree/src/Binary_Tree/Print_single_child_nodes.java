package Binary_Tree;

import java.util.Stack;

import Binary_Tree.Constuctor_binary_tree.Pair;

public class Print_single_child_nodes {

	public static void main(String[] args) {
		
		Integer arr[]= {50,25,12,null,null,37,30,null,null,40,null,null,75,62,60,null,null,70,null,null,87,null,null};
		Node root=input(arr);
     	printSingleChildNodes(root,null);

	}
	
	public static Node input(Integer arr[]) {
		
		int i=0;
		
		   Node root= new Node(arr[0],null,null);
		   Pair rp= new Pair(root,1);
		   
		   Stack<Pair> st= new Stack<>();
		   st.push(rp);
		   
		   
		   while(st.size()>0) {
			   
			   Pair top= st.peek();
			   
			   if(top.state==1) {
				   
				   i++;
				   
				   if(arr[i]!=null) {
					   
				   Node ln=new Node(arr[i], null, null);
				   top.node.left=ln;
				   
				   Pair lp= new Pair(ln,1);
				   st.push(lp);
				   
				   }else {
					   
					   top.node.left=null;
				   }
				   top.state++;
			   }
			   
			   else if(top.state==2) {
				   
				   i++;
				   
				   if(arr[i]!=null) {
					   
					   Node rn= new Node(arr[i],null,null);
					   
					   top.node.right=rn;
					   
					   Pair rip=new Pair(rn,1);
					   st.push(rip);
				   }else {
					   top.node.right=null;
				   }
				   
				   top.state++;
			   }else {
				  
				   st.pop();
			   }
			 }
		   
		   return root;
}
	

	
	public static void printSingleChildNodes(Node node,Node parent){
	
//		if(root==null) {
//			return;
//		}
//		else if(root.left!=null && root.right==null) {
//			System.out.print(root.data + " ");
//		}
//		else if(root.left==null && root.right!=null) {
//			System.out.print(root.data + " ");
//			
//		}
//		
//		
//		printSingleChildNodes( root.left);
// 	    printSingleChildNodes( root.right);
//		
//		if(node==null) {
//			return;
//		}
//		if(parent!=null && parent.left==node && parent.right==null) {
//			System.out.println(node.data+ " " );
//			
//		}else if( parent!=null && parent.left==null && parent.right==node) {
//			System.out.println(node.data + " ");
//		}
//		
//		printSingleChildNodes( node.left,node);
//    	printSingleChildNodes( node.right,node);
		
		
		 
			    if(node == null){
			      return;
			    }

			    if(parent != null && parent.left == null && parent.right == node){
			      System.out.println(node.data);
			    } else if(parent != null && parent.right == null && parent.left == node){
			      System.out.println(node.data);
			    }

			    printSingleChildNodes(node.left, node);
			    printSingleChildNodes(node.right, node);
			  

	
    }
}
