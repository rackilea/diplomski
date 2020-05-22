import java.io.FileNotFoundException;   
import java.util.Scanner;   
import org.apache.jmeter.samplers.SampleResult;

File file = new File("path/to/file/output.txt");  
String word = "Req String1";  
String word2 = "Req String2";  
Scanner scanner = null;  
String line;   
String s1;  
String s2;     
try {
   scanner = new Scanner(file); }    
  catch(FileNotFoundException e) {     //handle this }

 //now read the file line by line     

 while (scanner.hasNextLine()) {  
line = scanner.nextLine();

if(line.contains(word)) {   
   log.info(line);  
   s1=line;    
  //now the entire line along with Req String1 will be stored in s1
}

if(line.contains(word2)) { 
  log.info(line);
   s2=line;
}
 }

log.info("The value in Encrypt str  ="+s1);  
log.info("The value in Signatr str  ="+s2);  
String[] s1 = s1.split(":");  
String[] s2 =s2.split(":");  
//since my value in the line is Req String1:needed data

props.put("s1",s1[1]);  
props.put("s2",s2[1]);

log.info("The value in ORIGINAL Req String1  ="+props.get("s1"));
log.info("The value in ORIGINAL Req String2  ="+props.get("s2"));
scanner.close();