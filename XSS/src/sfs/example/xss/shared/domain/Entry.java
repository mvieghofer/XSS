/**
 */
package sfs.example.xss.shared.domain;

import java.util.Date;

/**
 * filename: Entry.java
 * 
 * @date: 13.01.2012
 * @author: Markus Vieghofer
 * 
 */
public class Entry {
  private String text;
  private Date date;
  private Author author;
  
  public Entry () {
    
  }
  
  public Entry (String text, Date date, Author author) {
    setText(text);
    setDate(date);
    setAuthor(author);
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text
   *          the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * @return the date
   */
  public Date getDate() {
    return date;
  }

  /**
   * @param date
   *          the date to set
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * @return the author
   */
  public Author getAuthor() {
    return author;
  }

  /**
   * @param author
   *          the author to set
   */
  public void setAuthor(Author author) {
    this.author = author;
  }
}
