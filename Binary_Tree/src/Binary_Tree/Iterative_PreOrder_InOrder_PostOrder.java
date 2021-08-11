package Binary_Tree;

import java.util.Stack;

import Binary_Tree.Constuctor_binary_tree.Pair;

public class Iterative_PreOrder_InOrder_PostOrder {

	public static void main(String[] args) {
		Integer arr[]= {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		Node root=input(arr);
		IterativeTraversal(root);


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

	
	
	//state=1 --> PreOrder, State++, left ko call;
	//State=2 --> InOrder, State++, right ko call;
	//State=3 --> PostOrder, state++, pop;
	// Initially state= 1
	
	
	private static class Pair{
		Node node;
		int state;
		
		public Pair(Node node, int state) {
			this.node=node;
			this.state=state;
		}
	}
	public static void IterativeTraversal(Node root) {
		
		Pair rp= new Pair(root,1);
		Stack <Pair> st = new Stack<>();
		String Pre=" ";
		String In= " ";
		String Post=" ";
		
		st.push(rp);
		
		while(st.size()>0) {
			
			Pair top= st.peek();
			
			if(top.state==1) {
				
				Pre+=top.node.data+ " ";
				
				if(top.node.left!=null) {
					Pair lp=new Pair(top.node.left,1);
					st.push(lp);
				}
				
				top.state++;
				
			}
			else if( top.state==2) {
				
				In+=top.node.data+" ";
				
				if(top.node.right!=null) {
					
					Pair rip=new Pair(top.node.right,1);
					st.push(rip);
				}
				top.state++;
			}
			
			else {
				
				Post+=top.node.data+ " ";
				st.pop();
			}
		}
		
		System.out.println(Pre);
		System.out.println(In);
		System.out.println(Post);
		
		
		
	}

}
