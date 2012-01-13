/**
 */
package sfs.example.xss.client.view;

import sfs.example.xss.client.common.CssClasses;
import sfs.example.xss.shared.domain.Entry;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

/**
 * filename: CommentEntry.java
 * 
 * @date: 13.01.2012
 * @author: Markus Vieghofer
 * 
 */
public class CommentEntry extends FlowPanel {

  public CommentEntry() {

  }

  public CommentEntry(Entry entry, int id) {
    setStyleName(CssClasses.COMMENT_CONTAINER);

    Label lblId = new Label(id + "");
    lblId.setStyleName(CssClasses.COMMENT_ID);

    FlowPanel header = new FlowPanel();
    header.setStyleName(CssClasses.COMMENT_HEADER);

    Label lblDate = new Label(DateTimeFormat.getFormat("dd. MMM yyyy, HH:mm")
        .format(entry.getDate()));
    lblDate.setStyleName(CssClasses.DATE);

    Label lblAuthor = new Label(entry.getAuthor().getName() + " wrote");
    lblAuthor.setStyleName(CssClasses.AUTHOR);

    header.add(lblDate);
    header.add(lblAuthor);
    header.add(lblId);

    HTML lblText = new HTML();
    lblText.setHTML(entry.getText());

    add(header);
    add(lblText);
  }
}
