package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

import Binary_Tree.Constuctor_binary_tree.Pair;



public class Node_to_root_path {

	public static void main(String[] args) {
	
		Integer arr[]= {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		Node root=input(arr);
	
		System.out.println(NodeToRootPath(root, 87));
		
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
	
	
	public static void display(Node root) {
		if(root==null) {
			return;
		}
	
		String str=" ";
		
		str+=root.left==null? " . " : root.left.data+" ";
		str+=" <- "+ root.data+ " -> ";
		str+=root.right==null?" . ":root.right.data+" ";
		
		System.out.println(str);
		
		display(root.left);
		display(root.right);
	}
	

	
	public static ArrayList NodeToRootPath(Node root, int data) {
		
		if(root==null) {
			ArrayList<Integer> bres= new ArrayList<>();
			return bres;
		}
		
		
		if(root.data==data) {
			ArrayList<Integer> res= new ArrayList<>();
			res.add(root.data);
			return res;
		}
		
		ArrayList<Integer> lp= NodeToRootPath(root.left,data);
		if(lp.size()>0) {
			lp.add(root.data);
			return lp;
		}
		ArrayList<Integer> rp= NodeToRootPath(root.right,data);
		if(rp.size()>0) {
			rp.add(root.data);
			return rp;
		}

		return new ArrayList<>();
	}
}
