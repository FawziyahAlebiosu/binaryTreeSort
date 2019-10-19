package experimenting;
/*Fawziyah Alebiosu, CMSC 350, Project THREE
 * 
 * This program takes in a list of integers and fractions, creates a binary search tree, 
 * and sorts the input. Based off the order the user wants; ascending, 
 * or descending, it returns a sorted output. 
 */


import javax.swing.JOptionPane;

import java.lang.Comparable;
/*This class contains the generic blue print to define the fraction nodes(Node class),
 *  compares fraction input and sorts it.
 */
public class binarySearchTreeFraction implements Comparable<binarySearchTreeFraction> {
	   
	    Node root;
	    private int top;//numerator
	    public int bottom;//denominator
	    StringBuilder str = new StringBuilder();
	    StringBuilder str2 = new StringBuilder();

	        
	        class Node {
	        	/*This inner class serves as the generic blueprint for the fraction nodes. 
	        	 * Using its constructor, it converts the String fraction into integers.
	        	 * and it implements the compareTo method.
	        	 */
	            Node left;
	            Node right;
	            String data;

	            public Node(String data) {
	            	//constructor
	                String[] fractionWithoutDivider = data.split("/");
	                //check for odd fractions like 3/4/5
	                
	                try{
	                if(fractionWithoutDivider.length > 2){
	                    throw new NumberFormatException("Not possible");
	                }
	                }
	                catch(NumberFormatException e){
	                	JOptionPane.showMessageDialog(null, "you have entered a fraction that is not an accepted format");
	                }
	                
	                top = Integer.parseInt(fractionWithoutDivider[0]);
	                bottom = Integer.parseInt(fractionWithoutDivider[1]);
	                //this basically acts as a toString equivalent
	                this.data = top + "/" + bottom;
	                this.left = null;
	                this.right = null;
	            }
	        }
	    public int getDenominator() {
	        return bottom;
	    }
	    public int getNumerator() {
	        return top;
	    }

	    @Override
	    public int compareTo(binarySearchTreeFraction fraction) {
	    	//allows the tree to compare fractions and decide where to place nodes. 

	        int firstFraction = top *  fraction.getDenominator() ;
	        int secondFraction = bottom * fraction.getNumerator();
	        int outcome = firstFraction - secondFraction;
	        return outcome;
	    }
	    
	    public  void insertNode(String value){
	    	
	        //inserts nodes into the search tree

	       Node newNode = new Node(value);

	        if(root == null){

	            root = newNode;
	        }
	           else{
	            Node current = root;
	            Node parent;
	            while(true) {
	                parent = current;
	                if (value.compareTo(current.data)<0)
	                    //if value is smaller than the current.data
	                    {
	                    current = current.left;
	                    if (current == null) {
	                        parent.left = newNode;
	                        return;
	                    }
	                } else{
	                    current = current.right;
	                    if (current == null) {
	                        parent.right = newNode;
	                        return;
	                    }
	                }
	            }}}
	    public String inOrderWalk(Node current) {
	        //basicaly the  ascending order
	        if (current!= null) {
	           inOrderWalk(current.left);
	           str2.append(current.data + " ") ;
	           inOrderWalk(current.right);
	        }
	       return str2.toString();
	    }
	  public String preOrderWalk(Node current){
	        //for the descending order
	        if(current!= null){
	            preOrderWalk(current.right);
	            str.append(current.data + " ");
	            preOrderWalk(current.left);
	        }
	        return str.toString();
	    }

}

