/*
 * Filename: PostfixToInfix.java
 * Author: John Kaiser
 * Date: 4-9-19
 * GUI to build expression tree, convert postfix expression to infix
 * and generate a file that contains the three address format instructions. 
 */
package postfixtoinfix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PostfixToInfix extends JFrame implements ActionListener {
    //Declare private JFrame components
    private JLabel enterLabel = new JLabel("Enter Postfix Expression: ");
    private JTextField inputTextField = new JTextField("");
    private JButton constructButton = new JButton("Construct Tree");
    private JLabel infixLabel = new JLabel("Infix Expression: ");
    private JTextField infixTextField = new JTextField("");
    
    private static String input;

    //Constructor
    public PostfixToInfix() {
        super("Three Address Generator");
        
        //Set resultTextField as uneditable
        infixTextField.setEditable(false);
        //Add actionListener to constructButton
        constructButton.addActionListener(this);
        
        //set the layout using group layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addContainerGap(20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(enterLabel)
                        .addComponent(infixLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(inputTextField)
                        .addComponent(constructButton)
                        .addComponent(infixTextField))
                .addContainerGap(20, 20));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addContainerGap(20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(enterLabel)
                        .addComponent(inputTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(constructButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(infixLabel)
                        .addComponent(infixTextField))
                .addContainerGap(20, 20));
        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Get user's input expression
            input = inputTextField.getText();
            //Tokenize user's expression
            ExpressionTree.tokenize(input);
        
            //Display result
            infixTextField.setText(ExpressionTree.printInfix());
            
        } catch (InvalidTokenException t) {
        } 
    }
    
    private void display() {
        setVisible(true);
        //Centers the frame on the screen
        setLocationRelativeTo(null);
        //Sets the window to be closeable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,150);
    }

    public static void main(String[] args) {
        PostfixToInfix test = new PostfixToInfix();
        test.display();
    }    
}
