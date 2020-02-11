/*
 * Filename: Operator.java
 * Author: John Kaiser
 * Date: 4-9-19
 * Abstract operator class for building correct operators. 
 */
package postfixtoinfix;

public abstract class Operator {
}

class AddOperator extends Operator {
    public String toString() {
        return "+";
    }
}
   
class MulOperator extends Operator {
    public String toString() {
        return "*";
    }
}
   
class SubOperator extends Operator {
    public String toString() {
        return "-";
    }
}
   
class DivOperator extends Operator {
    public String toString() {
        return "/";
    }
}
