/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

/*
* Christopher Chism
* Qtime Application
* Created: March 25, 2018
* Last Modified: March 27, 2019
* CSCI Course: 325
* Grade Received:	100
* Comments regarding design: Do not recall comments.
*/

public class nonGUITesting
{
    public static void main(String[] args)
    {
        Qtime list = new Qtime();
        String[] books = {
            "Genesis", 
            "Exodus",
            "Deuteronomy",
            "Judges",
            "Judges",
            "Judges",
            "Judges",
            "Judges",           
            "Exodus",
            "Exodus",
            "1 Chronicles",
            "Psalm"
        };
        
        String[] verse = {
            "1", "2", "3", "4", "5", "5", "5", "5", "5", "5", "5", "6"       
        };
        
        String[] randomNote = {
            "This is note one", 
            "This is note two", 
            "This is note three", 
            "This is note four", 
            "This is note five", 
            "This is note six",
            "This is note seven",
            "This is note eight",
            "This is note nine",
            "This is note ten",
            "This is note eleven",
            "This is note twelve"
            
        };
        
        //TEST CONSTRUCTOR()
        for(int i = 0; i < 12; i++)
        {
            System.out.println("Index:\t" + i + "\nBook:\t" + books[i] + "\nVerse:\t" + verse[i] + "\nNote:\t" + randomNote[i]);
            list.setNote(new QtimeNote(books[i], verse[i], randomNote[i]));
        }
        
        System.out.println("List size: " + list.getNoteListSize());
        
        System.out.println(list);
        
        System.out.println("getBookOfBible");
        System.out.println("getDate");
        System.out.println("getUserNotes");
        System.out.println("getVerseRef");
        
        System.out.println("Printing list pre- sorting:");
        
        for(int i = 0; i < list.getNoteListSize(); i++)
        {
            System.out.print(list.getNoteList().get(i).getBookOfBible());
            System.out.print(list.getNoteList().get(i).getDate());
            System.out.print(list.getNoteList().get(i).getUserNotes());
            System.out.println(list.getNoteList().get(i).getVerseRef());
            
        }
        
        System.out.println("Printing list post sorting:");
        
        list.sortNotes();
        
        for(int i = 0; i < list.getNoteListSize(); i++)
        {
            System.out.print(list.getNoteList().get(i).getBookOfBible());
            System.out.print(list.getNoteList().get(i).getDate());
            System.out.print(list.getNoteList().get(i).getUserNotes());
            System.out.println(list.getNoteList().get(i).getVerseRef());
            
        }

        System.out.println("Update user note for Exodus");
       
        list.updateUserNote(list.getNoteList().get(7), "Updated Note 1");
        list.updateUserNote(list.getNoteList().get(10), "Updated Note 2");
        
        for(int i = 0; i < list.getNoteListSize(); i++)
        {
            System.out.print(list.getNoteList().get(i).getBookOfBible());
            System.out.print(list.getNoteList().get(i).getDate());
            System.out.print(list.getNoteList().get(i).getUserNotes());
            System.out.println(list.getNoteList().get(i).getVerseRef());
            
        }
        
        System.out.println("Comparing Deuteronomy to Judges:\nOutput is:\t" + list.getNoteList().get(1).compareTo(list.getNoteList().get(4)));
    
        System.out.println("Remove notes from Exodus");
        list.removeNotes("Exodus");
        
        for(int i = 0; i < list.getNoteListSize(); i++)
        {
            System.out.print(list.getNoteList().get(i).getBookOfBible());
            System.out.print(list.getNoteList().get(i).getDate());
            System.out.print(list.getNoteList().get(i).getUserNotes());
            System.out.println(list.getNoteList().get(i).getVerseRef());
            
        }
    }
}
