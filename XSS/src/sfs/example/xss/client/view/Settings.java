/**
 */
package sfs.example.xss.client.view;

import sfs.example.xss.client.Blog;
import sfs.example.xss.client.common.CssClasses;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * filename: Settings.java
 *
 *     @date: 14.01.2012
 *   @author: Markus Vieghofer
 *
 */
public class Settings extends FlowPanel {
  public Settings(final Blog blog) {
    
    setStyleName(CssClasses.SETTINGS_OUTERPANEL);
    
    FlowPanel innerContainer = new FlowPanel();
    innerContainer.setStyleName(CssClasses.SETTINGS);
    
    final CheckBox cb = new CheckBox("XSS enabled");
    cb.setValue(blog.getXSSEnabled());
    cb.addClickHandler(new ClickHandler() {
      
      @Override
      public void onClick(ClickEvent event) {
       blog.setXSSEnabled(!blog.getXSSEnabled());
       cb.setValue(blog.getXSSEnabled());
      }
    });
    
    Anchor close = new Anchor("close");
    close.setStyleName(CssClasses.CLOSE_ANCHOR);
    close.addClickHandler(new ClickHandler() {
      
      @Override
      public void onClick(ClickEvent event) {
        removeSettingsPanel(blog);
      }
    });
    
    innerContainer.add(cb);
    innerContainer.add(close);
    
    add(innerContainer);
  }

  /**
   * @param blog
   */
  private void removeSettingsPanel(final Blog blog) {
    blog.removeSettingsPanel(this);
  }
}
