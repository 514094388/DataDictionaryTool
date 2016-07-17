package org.ccs.sandbox.sqltool;

import ysb.common.Config;

public class ConfigSet
  extends Config
{
  private ConfigSet()
  {
    init("sys.properties");
  }
  
  public static Config getInstance()
  {
    if (me == null) {
      me = new ConfigSet();
    }
    return me;
  }
}


/* Location:              D:\DataDictionaryTool_0.2.1beta with dependencies\DataDictionaryTool_0.2.1beta.jar!\org\ccs\sandbox\sqltool\ConfigSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */