/*
 * Filename: Node.java
 * Author: John Kaiser
 * Date: 4-9-19
 * Node interface to build nodes. 
 */
package postfixtoinfix;

import java.io.PrintWriter;

public interface Node {
    public String inOrderWalk();
    public void postOrderWalk(PrintWriter pw);
    public String getReg();
    public void printOutput();
}

