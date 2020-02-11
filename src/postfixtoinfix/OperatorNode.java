/*
 * Filename: OperatorNode.java
 * Author: John Kaiser
 * Date: 4-9-19
 * OperatorNode class to build and Operator Node with an operator and left and right operands. 
 */
package postfixtoinfix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class OperatorNode implements Node {

    private Node left, right;
    private Operator operator;
    private String leftValue;
    private String rightValue;
    private File file;
    private PrintWriter pw;
    private String register;
    private static int registerNumber = 0;
    private String operatorString;
   
    //Conctructor with 3 parameters
    public OperatorNode(Operator operator, Node left, Node right){
        this.operator = operator;
        this.left = left;
        this.right = right;
        this.operatorString = operator.toString();
    }
    
    //Set Register
    public void setReg() {
        this.register = "R" + registerNumber;
        registerNumber++;
    }
    
    //Get Register
    public String getReg() {
        return register;
    }
    
    // Initialize file and writer to print output to file, call methods
  // to print three address instructions to file and close writer
  public void printOutput() {
    file = new File("3AddressInstruction.txt");
    try {
      pw = new PrintWriter(file);
      this.postOrderWalk(pw);
      pw.close();
      registerNumber = 0;
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "File not found!");
    }
  }

    // Method to walk tree and print three address instructions to file
  public void postOrderWalk(PrintWriter pw) {
    left.postOrderWalk(pw);
    right.postOrderWalk(pw);
    if (this instanceof OperatorNode) {
      this.setReg();
    }
    leftValue = left.getReg();
    rightValue = right.getReg();
    pw.println(getOperator(operatorString) + " " + register + " "
        + leftValue + " " + rightValue);
  }

    public String inOrderWalk() {
        leftValue = left.inOrderWalk();
        rightValue = right.inOrderWalk();
        return "( " + leftValue + " " + operator + " " + rightValue + " )";
    }
    
    private static String getOperator(String operator) {
        switch (operator) {
            case "+":
                return "Add";
            case "-":
                return "Sub";
            case "*":
                return "Mul";
            case "/":
                return "Div";
            }
        return "Operator Not Found";
    }
}
