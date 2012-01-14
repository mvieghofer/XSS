/**
 */
package sfs.example.xss.client;

import sfs.example.xss.client.view.Settings;
import sfs.example.xss.shared.domain.Entry;

/**
 * filename: Blog.java
 *
 *     @date: 13.01.2012
 *   @author: Markus Vieghofer
 *
 */
public interface Blog {
  void addEntry(Entry entry);
  
  boolean getXSSEnabled();
  void setXSSEnabled(boolean xssEnabled);
 
  void removeSettingsPanel(Settings settings);
}
