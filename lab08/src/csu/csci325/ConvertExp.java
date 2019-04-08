/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * Christopher Chism
 * Program for Recursion and Stack
 * Created: September 17, 2018
 * Last Modified: March 26, 2019
 * CSCI Course: 325
 * Grade Received: 100
 * Comments regarding design: Do not recall comments.
 * 
 */
public class ConvertExp extends Object
{
    static public Stack<String> m_TempStack = new Stack<>();
    static private HashSet<Character> m_Operators;
    
    public ConvertExp()
    {

    }
    
    public static boolean isOperator(String note)
    {
        //Check for length codeblock
        m_Operators = new HashSet<>();
        m_Operators.add('+');
        m_Operators.add('-');
        m_Operators.add('*');
        m_Operators.add('/');
        
        if(note.length() > 0)
            return (m_Operators.contains(note.charAt(0))) ? true : false;
        else
            return false;
    }
    
    public static String postToInfix(String exp)
    {
        try
        {
            //try catch for empty stack and using malformed expression return
            String returnValue = "", tempA = "", tempB = "";
            if(exp != null)
            {
                for(int i = 0; i < exp.length(); i++)
                {
                    if(isOperator(Character.toString(exp.charAt(i))))
                    {
                        tempA = m_TempStack.pop();
                        tempB = m_TempStack.pop();
                        returnValue = "(" + tempB + exp.charAt(i) + tempA + ")";
                        m_TempStack.push(returnValue);
                    }else
                        m_TempStack.push(Character.toString(exp.charAt(i)));
                }
            }
            return m_TempStack.pop();
        }catch(EmptyStackException e)
        {
            return "Malformed expression: " + exp;
        }
    }
    
    public static String preToInfix(String exp)
    {
        try
        {
            //try catch for empty stack and using malformed expression return
            if(exp != null)
            {
                for(int i = exp.length() - 1; i >= 0 ; i--)
                {
                    if(isOperator(Character.toString(exp.charAt(i))))
                    {
                        m_TempStack.push("(" + m_TempStack.pop() + exp.charAt(i) + m_TempStack.pop() + ")");
                    }else
                        m_TempStack.push(Character.toString(exp.charAt(i)));
                }
            }
            return m_TempStack.pop();
        }catch(EmptyStackException e)
        {
            return "Malformed expression: " + exp;
        }
    }   
}