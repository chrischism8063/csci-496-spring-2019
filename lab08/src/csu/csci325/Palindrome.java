/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

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
public class Palindrome 
{
    
    public static boolean checkPal(String inputPhrase)
    {
        String newString = "";
        
        if(inputPhrase.length() > 0)
        {
            newString = inputPhrase.replaceAll("[^A-Za-z]+", "").toUpperCase();
        }
        
        return Palindrome.isIt(newString);
    }
    
    //recursive calling
    private static boolean isIt(String inputPhrase)
    {
        if(inputPhrase.length() == 0 || inputPhrase.length() == 1)
        {
            return true;
        }else if(inputPhrase.charAt(0) == inputPhrase.charAt(inputPhrase.length() - 1))
        {
            return isIt(inputPhrase.substring(1, inputPhrase.length() - 1));
        }else
        {
            return false;
        }
    }
}
