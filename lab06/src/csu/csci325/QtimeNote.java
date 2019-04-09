/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csu.csci325;

import java.util.Date;

/*
* Christopher Chism
* Qtime Application
* Created: March 25, 2018
* Last Modified: March 27, 2019
* CSCI Course: 325
* Grade Received:	100
* Comments regarding design: Do not recall comments.
*/

public class QtimeNote extends Object implements Comparable<QtimeNote>
{
    private String m_Book;
    private String m_Verse;
    private String m_Note;
    private Date m_Date;
    
    /**
     * 
     * @param book String title
     * @param verse String 
     * @param note String
     */
    public QtimeNote(String book, String verse, String note)
    {
        m_Book = book;
        m_Verse = verse;
        m_Note = note;
        m_Date = new Date();
    }

    /**
     * 
     * @return String of the title of the book
     */
    public String getBookOfBible()
    {                
        return m_Book;
    }
    
    /**
     * 
     * @return Date created at time of note recording 
     */
    public Date getDate()
    {
        return m_Date;
    }
    
    /**
     * 
     * @return 
     */
    public String getUserNotes()
    {
        return m_Note;
    }
    
    /**
     * 
     * @return String which contains verse
     */
    public String getVerseRef()
    {
        return m_Verse;
    }
    
    /**
     * 
     * @param newNotes Input 
     */
    public void updateUserNotes(String newNotes)
    {
        m_Note = m_Note.concat(newNotes);
    }
    
    /**
     * 
     * @param t input QtimeNote object to compare with local object
     * @return 
     */
    @Override
    public int compareTo(QtimeNote t)
    {
        return this.m_Book.concat(m_Verse).compareTo(t.m_Book.concat(t.m_Verse));
    }  
}
