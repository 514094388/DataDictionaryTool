package ysb.swt.dialog;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ShellUtil
{
  public static void makeShellCentered(Display paramDisplay, Shell paramShell)
  {
    Rectangle localRectangle1 = paramShell.getBounds();
    Rectangle localRectangle2 = paramDisplay.getBounds();
    int i = (localRectangle2.width - localRectangle1.width) / 2;
    int j = (localRectangle2.height - localRectangle1.height) / 2;
    paramShell.setLocation(i, j);
  }
  
  public static void makeShellMaximized(Display paramDisplay, Shell paramShell)
  {
    paramShell.setSize(paramDisplay.getBounds().width, paramDisplay.getBounds().height - 30);
    paramShell.setLocation(0, 0);
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\ysb\swt\dialog\ShellUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */