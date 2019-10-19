package experimenting;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*Fawziyah Alebiosu, CMSC 350, Project THREE
 * 
 * This program takes in a list of integers and fractions, creates a binary search tree, 
 * and sorts the input. Based off the order the user wants; ascending, 
 * or descending, it returns a sorted output. 
 */

public class collectDisplayGUI extends JFrame {
	/*This is the main class that defines the GUI, and calls the respective binary
	 * search tree methods and returns the correct output sorted in the right order
	 */
	    private static final int WIDTH = 500;
	    private static final int HEIGHT = 500;
	
	    private Handler handler;
	    
	    private JLabel originalList;
	    private JLabel sortList;
	    
	    private JTextField originalListInput;
	    private JTextField sortedListOutput;
	    
	    private JRadioButton ascendingButton;
	    private JRadioButton integerButton;
	    private JRadioButton fractionButton;
	    
	    private ButtonGroup numericTypeGroup;
	    private ButtonGroup sortOrderGroup;
	    
	    private JPanel panel;
	    private JPanel performSortButtonPanel;
	    private JPanel leftButtonPanel;
	    private JPanel rightButtonPanel;
	    private JPanel inputPanel;
	    private JPanel outputPanel;
	    private JPanel buttonsPanel;
	    
	    private JButton evaluate;

	    // Constructor for GUI
	    public collectDisplayGUI() {
	        // Customize the frame
	        super("Project Three: List Sorter");
	        setSize(WIDTH, HEIGHT);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

	        inputPanel = new JPanel();
	        inputPanel.setLayout(new FlowLayout());

	        originalList = new JLabel("Original List");
	        inputPanel.add(originalList);
	        originalListInput = new JTextField(25);
	        inputPanel.add(originalListInput);
	        panel.add(inputPanel);
	        
	        outputPanel = new JPanel();
	        outputPanel.setLayout(new FlowLayout());

	        sortList = new JLabel("Sorted List");
	        outputPanel.add(sortList);
	        sortedListOutput = new JTextField(25);
	        sortedListOutput.setEditable(false);
	        outputPanel.add(sortedListOutput);
	        panel.add(outputPanel);
	        
	        performSortButtonPanel = new JPanel();
	        performSortButtonPanel.setLayout(new FlowLayout());
	        evaluate = new JButton("Perform Sort");
	        performSortButtonPanel.add(evaluate);
	        handler = new Handler();
	        evaluate.addActionListener(handler);
	        panel.add(performSortButtonPanel);

	        buttonsPanel = new JPanel();
	        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
	        ascendingButton = new JRadioButton("Ascending");
	        ascendingButton.setSelected(true);
	        javax.swing.JRadioButton descendingButton = new JRadioButton("Descending");
	        sortOrderGroup = new ButtonGroup();
	        sortOrderGroup.add(ascendingButton);
	        sortOrderGroup.add(descendingButton);
	        integerButton = new JRadioButton("Integer");
	        integerButton.setSelected(true);
	        fractionButton = new JRadioButton("Fraction");
	        numericTypeGroup = new ButtonGroup();
	        numericTypeGroup.add(fractionButton);
	        numericTypeGroup.add(integerButton);
	        leftButtonPanel = new JPanel();
	        rightButtonPanel = new JPanel();
	        leftButtonPanel.setLayout(new BoxLayout(leftButtonPanel, BoxLayout.PAGE_AXIS));
	        rightButtonPanel.setLayout(new BoxLayout(rightButtonPanel, BoxLayout.PAGE_AXIS));
	        leftButtonPanel.setBorder(BorderFactory.createTitledBorder("Sort Order"));
	        rightButtonPanel.setBorder(BorderFactory.createTitledBorder("Numeric " + "Type"));
	        descendingButton.setAlignmentX(Component.LEFT_ALIGNMENT);
	        integerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
	        ascendingButton.setAlignmentX(Component.LEFT_ALIGNMENT);
	        fractionButton.setAlignmentX(Component.LEFT_ALIGNMENT);
	        leftButtonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	        rightButtonPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        leftButtonPanel.add(ascendingButton);
	        leftButtonPanel.add(descendingButton);
	        rightButtonPanel.add(integerButton);
	        rightButtonPanel.add(fractionButton);
	        leftButtonPanel.setMinimumSize(new Dimension(250, 75));
	        leftButtonPanel.setPreferredSize(new Dimension(250, 75));
	        rightButtonPanel.setMinimumSize(new Dimension(250, 75));
	        rightButtonPanel.setPreferredSize(new Dimension(250, 75));
	        leftButtonPanel.setMaximumSize(new Dimension(250, 75));
	        rightButtonPanel.setMaximumSize(new Dimension(250, 75));
	        buttonsPanel.add(leftButtonPanel);
	        buttonsPanel.add(rightButtonPanel);
	        panel.add(buttonsPanel);

	        add(panel);
	    }
	    public void display() {
	    	//the method that will actually make the frame appear
	        setVisible(true);
	    }

	    private class Handler implements ActionListener {
	        private String unsortedList[];
	        
	        private String unsortedListFraction[];
	        
	        binarySearchTree<Integer> integertree = new binarySearchTree<Integer>();
	        binarySearchTreeFraction fractiontree = new binarySearchTreeFraction();
	        public void actionPerformed(ActionEvent event) {
	            
	            if (integerButton.isSelected()) {
	            	//remove the space and dump the integers into an array
	                unsortedList = originalListInput.getText().split(" ");
	                //before inserting,check if it is all numeric input
	                try{
	                	  for (int i = 0; i < unsortedList.length; i++) {
	  	                    if(!unsortedList[i].matches("[0-9]+")){
	  	                    	throw new NumberFormatException("not possible");
	  	                    }} }
	                catch(NumberFormatException e){
	                	JOptionPane.showMessageDialog(null, "you have entered an integer that is not an accepted format");
	                }
	                //add all the items in the new array to the tree.
	                for (int i = 0; i < unsortedList.length; i++) {
	                    integertree.insertNode(Integer.parseInt(unsortedList[i]));
	                }
	            //call preorderWalk and inorderWalk as necessary
	            if (ascendingButton.isSelected()) {
	                sortedListOutput.setText(integertree.inOrderWalk(integertree.root));
	            } else {
	                sortedListOutput.setText(integertree.preOrderWalk(integertree.root));
	            }
	        }
	            if(fractionButton.isSelected()) {
	            	//remove the space and dump into an array
	            	unsortedListFraction = originalListInput.getText().split(" ");
	                }
	                for(int i = 0; i < unsortedListFraction.length; i++) {
	                    fractiontree.insertNode(unsortedListFraction[i]);
	            }
	                //call preorder and inorder as necessary
	            if (ascendingButton.isSelected()) {
	                sortedListOutput.setText(fractiontree.inOrderWalk(fractiontree.root));
	            } 
	            else {
	                sortedListOutput.setText(fractiontree.preOrderWalk(fractiontree.root));}
	         
	    }
	    }
	        
	    //Main method calling constructor to build and display the GUI
	    public static void main(String[] args) {
	        collectDisplayGUI gui = new collectDisplayGUI();
	        gui.display();
	    }
	}

