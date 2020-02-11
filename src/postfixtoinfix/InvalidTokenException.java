/*
 * Filename: InvalidTokenExpression.java
 * Author: John Kaiser
 * Date: 4-9-19
 * Project 2 exception to display message when invalid token is detected. 
 */
package postfixtoinfix;

import javax.swing.JOptionPane;

public class InvalidTokenException extends Exception {
    
    public InvalidTokenException(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
