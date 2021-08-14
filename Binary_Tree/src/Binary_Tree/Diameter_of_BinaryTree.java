package Binary_Tree;

import java.util.Stack;

import Binary_Tree.Constuctor_binary_tree.Pair;

public class Diameter_of_BinaryTree {

	public static void main(String[] args) {
		
		Integer arr[]= {50, 25, 12, null ,null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root=input(arr);
	    //display(root);


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

   
   
   //Diamater can be between deepest nodes(which is given by height) one node on the left and one node on the right --> lp.ht + rp.ht + 2
   // OR both nodes on one side only --> on left side lp.Dia;
   //OR both nodes on right side only --> rp.Dia
   
   //DIAMETER WILL BE MAXIMUM OF THESE ABOVE
   //FOR HEIGHT WE WILL SET IT TO -1 SO IF ONLY ROOT IS PRESENT THEN HEIGHT IS 0
   //FOR DIAMETER THR INITIAL VALUE IS 0
   public static class DiaPair{           
	   int ht;
	   int Dia;
   }
   
   public static DiaPair Diameter2(Node root) {
	   if(root==null) {
		   DiaPair bp=new DiaPair();
		   bp.ht=-1;
		   bp.Dia=0;
		   
	   }
	   
	   
	   DiaPair lp= Diameter2(root.left);
	   DiaPair rp= Diameter2(root.right);
	   
	   DiaPair my=new DiaPair();
	   my.ht=Math.max(lp.ht,rp.ht)+1;
	   my.Dia= Math.max(lp.ht+rp.ht+2, Math.max(lp.Dia, rp.Dia));
	   
	   return my;
	   
   }
   
}
