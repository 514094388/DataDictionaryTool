package ysb.common;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.apache.log4j.Logger;

public class ExceptionUtil
{
  private static final Logger log = Logger.getLogger(ExceptionUtil.class);
  
  public static String printStackTrace(Throwable paramThrowable)
  {
    log.error(paramThrowable);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramThrowable.printStackTrace(new PrintStream(localByteArrayOutputStream));
    return localByteArrayOutputStream.toString();
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\ysb\common\ExceptionUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */