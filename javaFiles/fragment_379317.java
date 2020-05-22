package junk;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main{
  private String scriptContent = '#!/bin/bash \n echo "yeah toast!" > /tmp/toast.txt';
  public void doIt(){
    try{
      Writer output = new BufferedWriter(new FileWriter("/tmp/toast.sh"));
      output.write(scriptContent);
      output.close();
      Runtime.getRuntime().exec("chmod u+x /tmp/toast.sh");
    }catch (IOException ex){}
  }

  public static void main(String[] args){
    Main m = new Main();
    m.doIt();
  }

}