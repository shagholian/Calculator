
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeinab
 */
public class test {
    public static void main(String[] args){
       Calculator c = new Calculator();
       String s = "1*3+(9/4+2*(6))";//3+2.25+12
       String postfix = c.infixToPostfix(s);
       double result = c.postfixEval(postfix);
       System.out.println(result);
    }
}
