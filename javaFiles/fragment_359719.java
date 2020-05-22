%include "typemaps.i"
%apply(char *STRING, int LENGTH) { (char *buff, int len) }; 
%inline {
   typedef struct {
        char*         buff;        
        int           len;  
  } workit_t;
}