/*
 * Filename: OperandNode.java
 * Author: John Kaiser
 * Date: 4-9-19
 * OperandNode class to build operands from integers. 
 */
package postfixtoinfix;

import java.io.PrintWriter;

public class OperandNode implements Node {
    private int value;
    
    //Constructor with 1 parameter for int value
    public OperandNode(int value) {
        this.value = value;
    }

    public String inOrderWalk() {
        return String.valueOf(value);
    }

    @Override
    public void postOrderWalk(PrintWriter pw) {
    }

    @Override
    public String getReg() {
        return this.inOrderWalk();
    }

    @Override
    public void printOutput() {
    }

}

