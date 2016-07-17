package org.ccs.sandbox.sqltool.datamodel.oracle;

import java.io.Serializable;

public class ToadSQL
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String tableName;
  private Field[] fields;
  private String charset;
  private String engine;
  
  public Field[] getFields()
  {
    return this.fields;
  }
  
  public void setFields(Field[] paramArrayOfField)
  {
    this.fields = paramArrayOfField;
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
  
  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
  
  public String getCharset()
  {
    return this.charset;
  }
  
  public void setCharset(String paramString)
  {
    this.charset = paramString;
  }
  
  public String getEngine()
  {
    return this.engine;
  }
  
  public void setEngine(String paramString)
  {
    this.engine = paramString;
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\org\ccs\sandbox\sqltool\datamodel\oracle\ToadSQL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */