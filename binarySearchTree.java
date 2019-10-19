package experimenting;
/*Fawziyah Alebiosu, CMSC 350, Project THREE
 * 
 * This program takes in a list of integers and fractions, creates a binary search tree, 
 * and sorts the input. Based off the order the user wants; ascending, 
 * or descending, it returns a sorted output. 
 */


public class binarySearchTree<Integer> {
/*This class contains the generic blue print to define the integer nodes(Node class),
 *  and sorts the input.
*/
	    Node root;
	    StringBuilder str = new StringBuilder();

	    class Node {
	    	//This inner class serves as the generic blueprint for the integer  nodes. 
	       int data;
	       //aka the keys for the tree
	       Node left;
	       Node right;

	    public Node(int data) {
	    	//constructor
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
	public  void insertNode(int value){
	            //start with the top
	    Node newNode = new Node(value);
	    if(root == null){
	        root = newNode; }
	        else{
            Node current = root;

            Node parent;
            while(true) {

                parent = current;
                if (value < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;

                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }}}

	        public String inOrderWalk(Node current) {
	            //for ascending order
	            if (current!= null) {
	                inOrderWalk(current.left);
	                str.append(current.data + " ");
	                inOrderWalk(current.right);
	            }
	            return str.toString();
	        }
	  public String preOrderWalk(Node current){
	            //for descending order
	            if(current!= null){
	                preOrderWalk(current.right);
	                str.append(current.data + " ");
	                preOrderWalk(current.left);
	            }
	      return str.toString();
	        }
}


