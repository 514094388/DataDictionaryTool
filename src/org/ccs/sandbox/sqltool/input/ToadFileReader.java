package org.ccs.sandbox.sqltool.input;

import java.io.File;
import ysb.common.FileUtil;

public class ToadFileReader
{
  public String read(File paramFile, String paramString)
    throws Exception
  {
    return FileUtil.getFileContent(paramFile, paramString);
  }
  
  public String read(File paramFile)
    throws Exception
  {
    return FileUtil.getFileContent(paramFile, null);
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\org\ccs\sandbox\sqltool\input\ToadFileReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */