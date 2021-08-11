package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

import Binary_Tree.Constuctor_binary_tree.Pair;

public class Print_Nodes_k_distance_away {

	public static void main(String[] args) {
		
		Integer arr[]= {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		Node root=input(arr);
		NodesKDistanceAway (root, 25, 1);
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
		
    
	public static void NodesKDistanceAway(Node root, int data, int k) {
		ArrayList<Node> Path= NodeToRootPath(root,data);
		
		for(int i=0;i<Path.size(); ++i) {
			PrintKlevelsDown(Path.get(i), k-i ,i==0? null:Path.get(i-1));
		}
	}
	
	public static void PrintKlevelsDown(Node root, int k, Node Blocker) {
		
		if(root==null || k<0 || root==Blocker) {
			return;
		}
		
		if(k==0) {
			System.out.print(root.data +" ");
		}
		
		PrintKlevelsDown(root.left, k-1, Blocker);
		PrintKlevelsDown(root.right,k-1,Blocker);
	}


	
	public static ArrayList NodeToRootPath(Node root, int data) {
		
		if(root==null) {
			ArrayList<Node> bres= new ArrayList<>();
	        return bres;
		}
		
		if(root.data==data) {
			ArrayList<Node> res= new ArrayList<>();
			res.add(root);
			return res;
		}
		
		
		ArrayList<Node> lp= NodeToRootPath(root.left,  data);
		if(lp.size()>0) {
			lp.add(root);
			return lp;
		}
		
		ArrayList<Node> rp= NodeToRootPath(root.right,  data);
		if(rp.size()>0) {
			rp.add(root);
			return rp;
		}
		
		
		return new ArrayList<>();
	}
}


