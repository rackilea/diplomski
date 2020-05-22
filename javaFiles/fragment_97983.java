Thread 1              Thread 2
--------------------------------------
Object d = data;
                      Object d = data;
                      data = null;
data = null;
return d;
                      return d;