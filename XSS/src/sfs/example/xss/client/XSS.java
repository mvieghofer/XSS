package sfs.example.xss.client;

import sfs.example.xss.client.view.BlogEntry;
import sfs.example.xss.client.view.CreateBlogEntry;
import sfs.example.xss.client.view.Settings;
import sfs.example.xss.shared.domain.Entry;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class XSS implements EntryPoint, Blog {

  private RootPanel rootPanel;
  private boolean xssEnabled = true;

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    rootPanel = RootPanel.get("entries");

    Button btnCreate = new Button("Create new blog entry");
    btnCreate.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        insertCreateEntryPanel();
      }

    });

    Button btnSettings = new Button("Settings");
    btnSettings.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        insertSettingsPanel();
      }
    });
    RootPanel.get("buttonContainer").add(btnCreate);
    RootPanel.get("buttonContainer").add(btnSettings);
  }

  /**
   * 
   */
  protected void insertSettingsPanel() {
    rootPanel.add(new Settings(this));
  }

  /**
   * 
   */
  protected void insertCreateEntryPanel() {
    rootPanel.insert(new CreateBlogEntry(this), 0);
  }

  @Override
  public void addEntry(Entry entry) {
    rootPanel.remove(0);
    rootPanel.add(new BlogEntry(entry, this));
  }

  @Override
  public boolean getXSSEnabled() {
    return xssEnabled;
  }

  @Override
  public void setXSSEnabled(boolean xssEnabled) {
    this.xssEnabled = xssEnabled;
  }

  @Override
  public void removeSettingsPanel(Settings settings) {
    rootPanel.remove(settings);
  }
}
