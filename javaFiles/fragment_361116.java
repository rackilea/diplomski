int err = 0;
for(int i = 0;i<999999;i++) {
        try {
             numtostring(i);
        } catch (Exception e){                
            err++;
        }            
    }
System.out.println(err+" ERORRS");