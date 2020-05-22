%include various.i                    
%apply char *BYTE { char *buff };  //map a Java byte[] array to a C char array
%inline {
   typedef struct {
        char*         buff;        
        int           len;  
   } workit_t;
}