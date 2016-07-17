package org.ccs.sandbox.sqltool;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import ysb.common.FileUtil;

public class HelpDocument
{
  private String text;
  protected static HelpDocument me = null;
  
  private HelpDocument()
  {
    InputStream localInputStream = getClass().getClassLoader().getResourceAsStream("help.txt");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    FileUtil.transfer(localInputStream, localByteArrayOutputStream);
    try
    {
      this.text = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  public static HelpDocument getInstance()
  {
    if (me == null) {
      me = new HelpDocument();
    }
    return me;
  }
  
  public String getText()
  {
    return this.text;
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\org\ccs\sandbox\sqltool\HelpDocument.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */