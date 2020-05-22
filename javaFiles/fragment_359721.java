%include various.i                    
%apply char *NIOBUFFER { char *buff }; //map Java nio buffers to C char array
%inline {
   typedef struct {
        char*         buff;        
        int           len;  
   } workit_t;
}