/**
 */
package sfs.example.xss.client.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import sfs.example.xss.client.Blog;
import sfs.example.xss.client.common.CssClasses;
import sfs.example.xss.shared.domain.Entry;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * filename: BlogEntry.java
 *
 *     @date: 13.01.2012
 *   @author: Markus Vieghofer
 *
 */
public class BlogEntry extends FlowPanel {

  private List<Entry> commentList = new ArrayList<Entry>();
  
  private FlowPanel commentContainer = new FlowPanel();
  
  private Blog blog;
  
  public BlogEntry(Blog blog) {
    // create empty blog entry
    setStyleName(CssClasses.BLOG_ENTRY);
    this.blog = blog;
  }
  
  public BlogEntry(Entry entry, Blog blog) {
    setStyleName(CssClasses.BLOG_ENTRY);
    
    this.blog = blog;
    
    HTML msg = new HTML();
    msg.setHTML(entry.getText());
    msg.setStyleName(CssClasses.BLOG_TEXT);
    
    Label author = new Label();
    author.setText(entry.getAuthor().getName());
    author.setStyleName(CssClasses.AUTHOR);
    
    Label date = new Label();
    date.setText(DateTimeFormat.getFormat("dd. MMM yyyy, HH:mm").format(entry.getDate()));
    date.setStyleName(CssClasses.DATE);
    
    commentContainer.setStyleName(CssClasses.BLOG_ENTRY_COMMENT_CONTAINER);
    
    add(msg);
    add(date);
    add(author);
    add(new Separator());
    add(new CommentForm(this));
    add(commentContainer);
  }
  
  @Override
  public Iterator<Widget> iterator() {
    return getChildren().iterator();
  }

  @Override
  public boolean remove(Widget child) {
    boolean result = true;
    try {
      getChildren().remove(child);
    } catch (NoSuchElementException e) {
      result = false;
    } catch (IndexOutOfBoundsException e2) {
      result = false;
    }
    return result;
  }
  
  public void addComment(Entry entry) {
    if (commentList.size() == 0) {
      insert(new Separator(), getWidgetIndex(commentContainer));
    }
    commentList.add(entry);
    commentContainer.add(new CommentEntry(entry, commentList.size(), blog));
  }

}
