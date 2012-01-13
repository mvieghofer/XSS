/**
 */
package sfs.example.xss.client.view;

import java.util.Date;

import sfs.example.xss.client.Blog;
import sfs.example.xss.client.common.CssClasses;
import sfs.example.xss.shared.domain.Author;
import sfs.example.xss.shared.domain.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;

/**
 * filename: CreateBlogEntry.java
 * 
 * @date: 13.01.2012
 * @author: Markus Vieghofer
 * 
 */
public class CreateBlogEntry extends FlowPanel {
  
  private Author[] authors = { new Author("Markus Vieghofer", ""), new Author("Bernhard Altendorfer", "") };
  public CreateBlogEntry(final Blog blog) {
    setStyleName(CssClasses.CREATE_BLOG_ENTRY_CONTAINER);
    
    final TextArea txtEntry = new TextArea();
    txtEntry.setStyleName(CssClasses.CREATE_BLOG_ENTRY_TEXTAREA);

    Button btnAdd = new Button("Add");
    btnAdd.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
          Entry entry = new Entry(txtEntry.getText(), new Date(), authors[Random.nextInt(authors.length)]);
          blog.addEntry(entry);
      }
    });
    add(txtEntry);
    add(btnAdd);
  }
}
