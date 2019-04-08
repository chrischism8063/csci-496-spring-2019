/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

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
public class Compress 
{
  
    public static String compress(String phrase)
    {
        Stack<String> m_Stack = new Stack<>();

        //stores the number of similar occurance of the same type of character
        int charCount = 0;
        int tempSize = 0;
        String returnString = "", tempChar = "", tempNull = "";
        
        //First checks for null input of a blank string
        if(phrase == null || phrase == "")
        {
            return null;
        }
        //Below code runs as long as it is a valid string of characters
        else
        {
            for(int i = 0; i < phrase.length(); i++)
            {
                //If stack is not started, start by pushing
                if(m_Stack.empty())
                {
                    m_Stack.push(Character.toString(phrase.charAt(i)));
                    //start the count
                    charCount++;   
                    
                }
                //Checks to see if the previous item is similar to the current one
                else if(m_Stack.peek().equalsIgnoreCase(Character.toString(phrase.charAt(i))))
                {
                    m_Stack.push(Character.toString(phrase.charAt(i)));
                    charCount++;
                }
                //Checks to see if the previous item is not equal to the current one with having a charcount > 0, then it will compress the previous chars and add to stack
                else if(!m_Stack.peek().equalsIgnoreCase(Character.toString(phrase.charAt(i))) && Character.isAlphabetic(m_Stack.peek().charAt(0))|| i == phrase.length() - 1)
                {
                    //get char by popping until that size is over--clears stack of previous unused characters, but leaves one to add in the count
                    for(int a = i; a > i - charCount; a--)
                    {
                        tempNull = m_Stack.pop();
                    }
                    
                    //push number of items
                    m_Stack.push(tempNull);
                    
                    if(charCount != 1)
                    {
                        //set size value going into stack
                        tempSize = charCount;
                        m_Stack.push(Integer.toString(tempSize));
                    }
                    
                    
                    m_Stack.push(Character.toString(phrase.charAt(i)));
                    charCount = 1;
                }else
                {
                    //adds new character after popping--needs to be tested
                    m_Stack.push(Character.toString(phrase.charAt(i)));
                    charCount++;
                }
            }
            //TL
            //System.out.println("Size:" + m_Stack.size() + "CharCount:" + charCount);
            
            if(charCount > 0)
            {
                //get char by popping until that size is over--clears stack of previous unused characters, but leaves one to add in the count
                for(int z = charCount - 1; z > 0; z--)
                {
                    tempNull = m_Stack.pop();
                }
                //set size value going into stack
                tempSize = charCount;
                
                                    
                if(charCount != 1)
                {
                    //set size value going into stack
                    tempSize = charCount;
                    m_Stack.push(Integer.toString(tempSize));
                }
            }
            
            for(int z = 0; z < m_Stack.size(); z++)
            {
                returnString += m_Stack.get(z);
            }
        }
        return returnString;
    }
}
