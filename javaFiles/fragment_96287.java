while(true){ // infinite loop

    if (camera.read(iframe)) {
        System.out.println("Frame Obtained");
        System.out.println("Captured Frame Width " + 
        iframe.width() + " Height " + iframe.height());

        while(true) { // another infinite loop
            Highgui.imwrite(canvas, iframe);
        }
    }
}