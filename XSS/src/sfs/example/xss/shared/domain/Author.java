/**
 */
package sfs.example.xss.shared.domain;

import java.io.Serializable;

import com.google.gwt.user.client.Random;

/**
 * filename: Author.java
 * 
 * @date: 13.01.2012
 * @author: Markus Vieghofer
 * 
 */
public class Author implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1648902450985963159L;

  private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
  
  private String name;
  private String email;
  
  public Author () {
    setName(getRandomName());
  }
  
  /**
   * @return
   */
  private String getRandomName() {
    int upperBound = 10 + Random.nextInt(5);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < upperBound; i++) {
      sb.append(numbers[Random.nextInt(numbers.length)]);
    }
    setName(sb.toString());
    return getName();
  }

  public Author(String name, String email) { 
    setName(name);
    setEmail(email);
  }

  /**
   * @return the name
   */
  public String getName() {
    return ((name == null || name.equals("")) ? getRandomName() : name);
  }

  /**
   * @param name
   *          the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email
   *          the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
