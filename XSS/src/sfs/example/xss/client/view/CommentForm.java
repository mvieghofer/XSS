/**
 */
package sfs.example.xss.client.view;

import java.util.Date;

import sfs.example.xss.client.common.CssClasses;
import sfs.example.xss.shared.domain.Author;
import sfs.example.xss.shared.domain.Entry;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * filename: CommentForm.java
 *
 *     @date: 13.01.2012
 *   @author: Markus Vieghofer
 *
 */
public class CommentForm extends FlexTable {

  public CommentForm(final BlogEntry blogEntry) {
    Label lblUname = new Label();
    lblUname.setText("Username: (optional)");
    
    final TextBox txtUname = new TextBox();
    txtUname.setStyleName(CssClasses.COMMENT_TEXTBOX);
    
    Label lblEmail = new Label();
    lblEmail.setText("Email:");
    
    final TextBox txtEmail = new TextBox();
    txtEmail.setStyleName(CssClasses.COMMENT_TEXTBOX);
    
    final TextArea txtComment = new TextArea();
    txtComment.setStyleName(CssClasses.COMMENT_TEXT_AREA);
    
    Button btnSend = new Button("Send");
    btnSend.addStyleName(CssClasses.COMMENT_BUTTON);
    btnSend.addClickHandler(new ClickHandler() {
      
      @Override
      public void onClick(ClickEvent event) {
        Author author = new Author(txtUname.getText(), txtEmail.getText());
        Entry entry = new Entry(txtComment.getText(), new Date(), author);
        blogEntry.addComment(entry);
        txtUname.setText("");
        txtEmail.setText("");
        txtComment.setText("");
      }
    });
    
    getFlexCellFormatter().setColSpan(2, 0, 2);
    getFlexCellFormatter().setStyleName(0, 0, CssClasses.COMMENT_DESCRIPTION);
    getFlexCellFormatter().setStyleName(2, 2, CssClasses.COMMENT_BUTTON_CONTAINER);
    setWidget(0, 0, lblUname);
    setWidget(0, 1, txtUname);
    setWidget(1, 0, lblEmail);
    setWidget(1, 1, txtEmail);
    setWidget(2, 0, txtComment);
    setWidget(2, 2, btnSend);
  }
}
