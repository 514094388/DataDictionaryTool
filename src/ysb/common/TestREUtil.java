package ysb.common;

import java.io.PrintStream;

public class TestREUtil
{
  public static void main(String[] paramArrayOfString)
  {
    String str1 = "abc";
    String str2 = "^(abc).*";
    System.out.println(REUtil.matches(str1, str2));
    String[] arrayOfString = REUtil.getREGroupVector(str1, str2);
    for (int i = 0; i < arrayOfString.length; i++) {
      System.out.println(arrayOfString[i]);
    }
    System.out.println("OK");
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\ysb\common\TestREUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */