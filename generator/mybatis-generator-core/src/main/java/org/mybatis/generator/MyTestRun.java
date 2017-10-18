package org.mybatis.generator;  
  
import org.mybatis.generator.api.ShellRunner;  
  
public class MyTestRun {  
  
    public static void main(String[] args) {  
        String config = MyTestRun.class.getClassLoader().getResource("userConfigGenerator.xml").getFile();  
        String[] arg = { "-configfile", config, "-overwrite" };  
        ShellRunner.main(arg);  
    }  
  
}  