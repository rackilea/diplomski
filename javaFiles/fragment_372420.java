aload_0
iconst_1
putfield        #1; //Field private
return

public int getA();
  Code:
   0:   aload_0
   1:   getfield        #1; //Field private
   4:   ireturn

public void setA(int);
  Code:
   0:   aload_0
   1:   iload_1
   2:   putfield        #1; //Field private
   5:   return