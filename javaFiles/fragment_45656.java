START;
 loop:
     if (!CONDITION) {
         goto endloop;
     }
     STMT1;
     goto step;
     STMT2;
 step:
     STEP;
     goto loop;
 endloop: