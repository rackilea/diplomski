double v=0;
    double anterior=0;

    while (true) {
        double time=System.currentTimeMillis()+200;
        double currentTime=System.currentTimeMillis();
        double offset=0;
        int tries=0;
        double maximo=0;
        double minimo=0;
        while(time>currentTime){ //lets run for 0.2seconds :)

            try {
                double temp=-accel.getAccelY(); //front shouln't be negative
                tries++;
                if(temp<0.1201 && temp>-0.1201){
                    tries--; //oops threadshould sample
                }else{
                    if(temp>maximo)
                        maximo=temp;
                    if(temp<minimo)
                        minimo=temp;
                    offset+=temp;
                }   
            }catch (Exception e) {
                System.err.println("Caught " + e + " while collecting/sending sensor samples.");
            }
            Utils.sleep(10); //sleep 10milisecs
            currentTime=System.currentTimeMillis();
        }
        if(tries>2)
            offset=(offset-minimo-maximo)/(tries-2); //remove max value and min value from sample and makes average
        else if(tries>0)
            offset/=2; //you wont take max or min from a two value sample
        try {
            dg.reset();         //clears
            v=anterior+offset*0.2; //vf=vi+at
            dg.writeDouble(Math.abs(v*100)); // sends in cm
            anterior=offset;    //vi=vf
            rCon.send(dg);     //sends radiogram
            Utils.sleep(200); //sleep 0.2s
        }catch (Exception e) {
            System.err.println("Caught " + e + " while sending velocity.");
        }
    }
}