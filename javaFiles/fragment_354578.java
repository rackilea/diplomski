import java.util.*;
import java.lang.*;
import java.io.*;

Pattern p = Pattern.compile("(\\[(\\w+))|(,(\\w+))");
Matcher m = p.matcher("\"123\",\"45\",\"{\"VFO\":[B501], \"AGN\":[605,B501], \"AXP\":[665], \"QAV\":[720,223R,251Q,496M,548A,799M]}\",\"4\"");
StringBuffer s = new StringBuffer();
while (m.find()){
  if(m.group(2)!=null){
    m.appendReplacement(s, "[\""+m.group(2)+"\"");
  }else if(m.group(4)!=null){
    m.appendReplacement(s, ",\""+m.group(4)+"\"");
  }
}
m.appendTail(s);
print(s);