public int findKey(int keytofind){
       System.out.println("OPS : keytofind is: " + keytofind);
       System.out.println("OPS : start :findKey()");

       for (int h=0; h<contadoresCajas.length;h++){

           if (contadoresCajas[h][0] == keytofind ){
               keyfound=h;
               System.out.println("OPS : keyfound is: " + keyfound);
            }

       }
       System.out.println("OPS : end :findKey()");
       return keyfound;
   }


    public void cajaUnoCountIncrement(){
        System.out.println("OPS : cajaUnoCountIncrement()");
        c1++;
        kf = findKey(1);
        contadoresCajas[kf][1] = c1;
    }