public static void main(String[] args) {

    try {

        Context context = new Context();
        // add the NITE License 
        License license = new License("PrimeSense", "0KOIk2JeIBYClPWVnMoRKn5cdY4=");   // vendor, key
        context.addLicense(license); 

        DepthGenerator depth = DepthGenerator.create(context);


        Recorder recorder = Recorder.create(context, "oni"); 

        recorder.setDestination(RecordMedium.FILE, "KinectLog.oni");

        recorder.addNodeToRecording(depth);

        context.startGeneratingAll();

        int tmp = 0;
        while(tmp < 100){
            tmp++;
            context.waitAnyUpdateAll();
            recorder.Record();
            System.out.println("recording");
        }
        recorder.dispose();         

        }
        catch (GeneralException e) {
          System.out.println(e);
          System.exit(1);
        }

}