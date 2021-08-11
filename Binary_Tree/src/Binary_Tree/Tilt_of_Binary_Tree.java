package Binary_Tree;

import java.util.Stack;

import Binary_Tree.Constuctor_binary_tree.Pair;

public class Tilt_of_Binary_Tree {

	public static void main(String[] args) {
		
		Integer arr[]= {50, 25, 12, null ,null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root=input(arr);
	    //display(root);
		tilt=0;
		tilt(root);
		System.out.println(tilt);

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

	
	
	static int tilt ;
	  public static int tilt(Node root){
		  
		  if(root==null) {
			  return 0;
		  }
		   
		   int ls= tilt(root.left);
		   int rs= tilt(root.right);
		   
		   int ltilt=Math.abs(ls-rs);
		   
		   tilt+=ltilt;   //Pure tree ka total tilt kitna hai, hr node pr jo tilt aaega un sabka sum lena hai
		   
		   int totalSum= ls+rs+root.data;   //sum issliye chiye kyuki parent ko dono child ka sum chaiye apna tilt calculate karne ke liye.
		   
		   return totalSum;
		   
		   
	  }
}
