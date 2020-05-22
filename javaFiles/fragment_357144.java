//COZBATCH JOB CLASS=W,NOTIFY=&SYSUID                                  
//*                                                                    
//JOBLIB  DD DISP=SHR,DSN=COZ.LOADLIB                                  
//*                                                                    
//*====================================================================
//* Batch job to run the CoZLauncher.                                  
//*====================================================================
//RUNCOZ  EXEC PGM=COZBATCH                                            
//STDIN  DD *                                                          
cd /tmp                                                                
mkdir -p hello                                                         
cd hello                                                               
cat >HelloWorld.java <<EOF                                             
public class HelloWorld {                                              
   public static void main(String[] args) {                            
        System.out.println("Hello World!");                            
   }                                                                   
}                                                                      
EOF                                                                    
export JAVA_HOME=/usr/lpp/java/J7.1_64                                 
export PATH=$PATH:$JAVA_HOME/bin                                       
javac HelloWorld.java                                                  
java HelloWorld                              
/*