/*
 * Filename: ExpressionTree.java
 * Author: John Kaiser
 * Date: 4-9-19
 * ExpressionTree class to tokenize input from GUI and create tree. 
 */
package postfixtoinfix;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionTree {
    private static StringTokenizer st;
    private static String operators = "+-*/ ";
    private static String operator;
    private static int tokenInt;
    
    private static Node left;
    private static Node right;
    
    public static Node tree;
    
    //Creat stack of Strings for operators
    static Stack<String> operatorStack = new Stack<>();
    //Create tree stack to store Nodes
    static Stack<Node> treeStack = new Stack<>();
    
    public static void tokenize(String input) throws InvalidTokenException {
        st = new StringTokenizer(input, operators, true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!operators.contains(token)) { //check if token is NOT an operator, must be a number
                try {
                    Integer.parseInt(token); //Parse to integer
                } catch (NumberFormatException e) {
                    String errorMessage = "Invalid token ";
                    errorMessage = errorMessage + token;
                    throw new InvalidTokenException(errorMessage);
                }
                tokenInt = Integer.parseInt(token); //Parse to integer
                treeStack.push(new OperandNode(tokenInt)); //push OperandNode into treeStack
            } else if (!token.equals(" ")) { //make sure token is not a space
                operatorStack.push(token); //push String operator to Operator Stack
                if (treeStack.size() >= 2) { //Make sure there are 2 operand Nodes in tree Stack
                    Node newOperator = makeOperatorNode(); //create a new operator node
                    treeStack.push(newOperator); //push the new operator node into tree stack
                }
            }   
        }
        // Once it is all done there should be 1 OperatorNode in treeStack, pop it into tree node
        tree = (treeStack.pop());
        tree.printOutput();
    }
    
    //create OperatorNode with operator and left and right OperandNodes
    private static Node makeOperatorNode() {
        operator = operatorStack.pop();        
        right = treeStack.pop();
        left = treeStack.pop();

        Operator op = getOperator(operator);
        return new OperatorNode(op,left, right);
    }
    
    //Function to pass in String operator and return correct new Operator
    public static Operator getOperator(String operator) {
        Operator toReturn = null;
        if(operator.equals("+")) 
          toReturn = new AddOperator();
        if(operator.equals("-")) 
          toReturn = new SubOperator();
        if(operator.equals("*")) 
          toReturn = new MulOperator();
        if(operator.equals("/")) 
          toReturn = new DivOperator();
        return toReturn;
    }  
    
    public static String printInfix() {
        tree.printOutput();
        return tree.inOrderWalk();
    }
}
            
    
    
