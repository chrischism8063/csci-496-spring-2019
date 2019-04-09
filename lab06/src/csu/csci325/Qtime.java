/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
* Christopher Chism
* Qtime Application
* Created: March 25, 2018
* Last Modified: March 27, 2019
* CSCI Course: 325
* Grade Received:	100
* Comments regarding design: Do not recall comments.
*/

public class Qtime extends Object
{
    private List<QtimeNote> m_List;
    private int m_NoteListSize;
    
    /**
     * Constructor creates new List with LinkedList implemented methods along with setting membervariable size to 0
     */
    public Qtime()
    {
        m_List = new LinkedList<>();
        m_NoteListSize = 0;
    }
    
    /**
     * 
     * @return List of QtimeNotes
     */
    public List<QtimeNote> getNoteList()
    {
        return m_List;
    }
    
    /**
     * 
     * @return int value representing the size of the notelist
     */
    public int getNoteListSize()
    {
        m_NoteListSize = m_List.size();
        return m_NoteListSize;
    }
    
    /**
     * 
     * @param book input String for book user desires for all notes to be cleared
     */
    public void removeNotes(String book) 
    {
        QtimeNote newItem;
        //clears all notes matching book
        Iterator<QtimeNote> list = m_List.iterator();
        while(list.hasNext())
        {
            newItem = list.next();
            
            if(newItem.getBookOfBible().equalsIgnoreCase(book))
            {
                list.remove();
            }
        }
    }
    
    /**
     * 
     * @param note String to be added as a note
     */
    public void setNote(QtimeNote note) 
    {
        m_List.add(note);
    }
    
    /**
     * Sorts notes based on book and verse
     */
    public void sortNotes()
    {
        Collections.sort(m_List);
    }
    
    public void updateUserNote(QtimeNote note, String userNote)
    {
        m_List.get(m_List.indexOf(note)).updateUserNotes(userNote);
    }  
}
