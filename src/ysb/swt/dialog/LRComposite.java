package ysb.swt.dialog;

import java.io.File;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import ysb.common.C;
import ysb.common.ExceptionUtil;
import ysb.common.FileUtil;

public class LRComposite
{
  protected Composite leftComp;
  protected Text srcText;
  protected Combo loadEncodingCombo;
  protected Combo saveEncodingCombo;
  protected Composite buttonComp;
  protected Button okButton;
  protected Button cancelButton;
  protected String src;
  protected String initialText = "";
  protected int left = 5;
  protected int right = 5;
  protected ToolBar customizeToolbar;
  protected ToolItem customizeButton;
  protected Menu customizeMenu;
  protected static Display display = null;
  protected static Shell shell = new Shell();
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      LRComposite localLRComposite = new LRComposite();
      ShellUtil.makeShellCentered(display, shell);
      localLRComposite.makeComponents(shell);
      localLRComposite.readAndDispatch(display, shell);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void readAndDispatch(Display paramDisplay, Shell paramShell)
  {
    paramShell.open();
    paramShell.layout();
    while (!paramShell.isDisposed()) {
      if (!paramDisplay.readAndDispatch()) {
        paramDisplay.sleep();
      }
    }
  }
  
  protected void setTitle(Shell paramShell, String paramString)
  {
    paramShell.setText(paramString);
  }
  
  protected Shell getShell()
  {
    return shell;
  }
  
  public void makeComponents(final Shell paramShell)
  {
    init();
    addBe4SashForm();
    Object localObject1 = new SashForm(paramShell, 0);
    ((SashForm)localObject1).setLayoutData(new GridData(1808));
    this.leftComp = new Composite((Composite)localObject1, 0);
    renderLeftComp();
    Object localObject2 = new Composite((Composite)localObject1, 0);
    ((Composite)localObject2).setLayout(new GridLayout());
    Composite localComposite = new Composite((Composite)localObject2, 2048);
    localComposite.setLayoutData(new GridData(768));
    localComposite.setLayout(new RowLayout());
    Button localButton1 = new Button(localComposite, 8);
    localButton1.setText("Load");
    localButton1.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent paramAnonymousSelectionEvent)
      {
        FileDialog localFileDialog = new FileDialog(paramShell, 4096);
        String str1 = localFileDialog.open();
        if (str1 != null) {
          try
          {
            String str2 = FileUtil.getFileContent(new File(str1), LRComposite.this.loadEncodingCombo.getText());
            LRComposite.this.srcText.setText(str2);
          }
          catch (Exception localException)
          {
            LRComposite.this.error(localException);
          }
        }
      }
    });
    this.loadEncodingCombo = new Combo(localComposite, 0);
    this.loadEncodingCombo.add(C.FILE_ENCODING);
    this.loadEncodingCombo.add("UTF-8");
    this.loadEncodingCombo.add("GBK");
    this.loadEncodingCombo.add("");
    this.loadEncodingCombo.select(0);
    this.loadEncodingCombo.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent paramAnonymousSelectionEvent)
      {
        LRComposite.this.saveEncodingCombo.select(LRComposite.this.loadEncodingCombo.getSelectionIndex());
      }
    });
    Button localButton2 = new Button(localComposite, 8);
    localButton2.setText("Save");
    localButton2.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent paramAnonymousSelectionEvent)
      {
        FileDialog localFileDialog = new FileDialog(LRComposite.this.getShell(), 8192);
        localFileDialog.setFileName("tmp.txt");
        String str = localFileDialog.open();
        if (str != null) {
          try
          {
            FileUtil.setFileContent(new File(str), LRComposite.this.srcText.getText(), LRComposite.this.saveEncodingCombo.getText());
          }
          catch (Exception localException)
          {
            LRComposite.this.error(localException);
          }
        }
      }
    });
    this.saveEncodingCombo = new Combo(localComposite, 0);
    this.saveEncodingCombo.add(C.FILE_ENCODING);
    this.saveEncodingCombo.add("UTF-8");
    this.saveEncodingCombo.add("GBK");
    this.saveEncodingCombo.add("");
    this.saveEncodingCombo.select(0);
    createCustomizeToolBar(localComposite);
    this.srcText = new Text((Composite)localObject2, 2562);
    this.srcText.setLayoutData(new GridData(1808));
    this.srcText.setText(this.initialText);
    this.srcText.addListener(1, new Listener()
    {
      public void handleEvent(Event paramAnonymousEvent)
      {
        if ((paramAnonymousEvent.stateMask == 262144) && (paramAnonymousEvent.keyCode == 97)) {
          LRComposite.this.srcText.selectAll();
        }
      }
    });
    ((SashForm)localObject1).setWeights(new int[] { getLeft(), getRight() });
    this.buttonComp = new Composite(paramShell, 2048);
    localObject1 = new GridData();
    ((GridData)localObject1).horizontalAlignment = 3;
    this.buttonComp.setLayoutData(localObject1);
    localObject2 = new RowLayout();
    ((RowLayout)localObject2).spacing = 15;
    this.buttonComp.setLayout((Layout)localObject2);
    this.okButton = new Button(this.buttonComp, 8);
    this.okButton.setText("   OK   ");
    this.okButton.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent paramAnonymousSelectionEvent)
      {
        LRComposite.this.okPressed();
      }
    });
    this.cancelButton = new Button(this.buttonComp, 8);
    this.cancelButton.setText("Cancel");
    this.cancelButton.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent paramAnonymousSelectionEvent)
      {
        LRComposite.this.cancelPressed();
      }
    });
  }
  
  private void createCustomizeToolBar(Composite paramComposite)
  {
    this.customizeToolbar = new ToolBar(paramComposite, 4);
    this.customizeButton = new ToolItem(this.customizeToolbar, 64);
    this.customizeButton.setText("Customize");
    this.customizeMenu = new Menu(paramComposite.getShell(), 8);
    addFunctionMenuItem();
    this.customizeButton.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent paramAnonymousSelectionEvent)
      {
        Rectangle localRectangle = LRComposite.this.customizeButton.getBounds();
        Point localPoint = new Point(localRectangle.x, localRectangle.y + localRectangle.height);
        localPoint = LRComposite.this.customizeToolbar.toDisplay(localPoint);
        LRComposite.this.customizeMenu.setLocation(localPoint.x, localPoint.y);
        LRComposite.this.customizeMenu.setVisible(true);
      }
    });
  }
  
  protected void addFunctionMenuItem()
  {
    Function[] arrayOfFunction = getFunctions();
    if (arrayOfFunction != null) {
      for (int i = 0; i < arrayOfFunction.length; i++)
      {
        final Function localFunction = arrayOfFunction[i];
        MenuItem localMenuItem = new MenuItem(this.customizeMenu, 8);
        localMenuItem.setText(localFunction.getText());
        localMenuItem.addSelectionListener(new SelectionAdapter()
        {
          public void widgetSelected(SelectionEvent paramAnonymousSelectionEvent)
          {
            localFunction.execute();
          }
        });
      }
    }
  }
  
  protected Function[] getFunctions()
  {
    return null;
  }
  
  protected void okPressed()
  {
    getShell().dispose();
  }
  
  protected void cancelPressed()
  {
    getShell().dispose();
  }
  
  protected void renderLeftComp() {}
  
  protected void addBe4SashForm() {}
  
  protected void init() {}
  
  public String getSrc()
  {
    return this.src;
  }
  
  public void setSrc(String paramString)
  {
    this.src = paramString;
  }
  
  protected void error(Throwable paramThrowable)
  {
    MessageDialog.openInformation(getShell(), "Error", ExceptionUtil.printStackTrace(paramThrowable));
  }
  
  protected void info(String paramString)
  {
    MessageDialog.openInformation(getShell(), "Message", paramString);
  }
  
  protected void info(String paramString1, String paramString2)
  {
    MessageDialog.openInformation(getShell(), paramString1, paramString2);
  }
  
  public int getLeft()
  {
    return this.left;
  }
  
  public void setLeft(int paramInt)
  {
    this.left = paramInt;
  }
  
  public int getRight()
  {
    return this.right;
  }
  
  public void setRight(int paramInt)
  {
    this.right = paramInt;
  }
  
  static
  {
    shell.setLayout(new GridLayout());
    shell.setSize(700, 500);
    shell.setText("SWT Application");
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\ysb\swt\dialog\LRComposite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */