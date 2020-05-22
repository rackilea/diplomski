private void readAnswer() {
    long startTime;
    for(int j =0; j<resultString.length(); j++)
    {
     int i = resultString.charAt(j);
    switch(i) {
        case '1':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < one.getDuration()) {
                one.start();
            }
            break;
        case '2':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < two.getDuration()) {
                two.start();
            }
            break;
        case '3':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < three.getDuration()) {
                three.start();
            }
            break;
        case '4':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < four.getDuration()) {
                four.start();
            }
            break;
        case '5':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < five.getDuration()) {
                five.start();
            }
            break;
        case '6':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < six.getDuration()) {
                six.start();
            }
            break;
        case '7':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < seven.getDuration()) {
                seven.start();
            }
            break;
        case '8':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < eight.getDuration()) {
                eight.start();
            }
            break;
        case '9':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < nine.getDuration()) {
                nine.start();
            }
            break;
        case '0':
            startTime =  System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < zero.getDuration()) {
                zero.start();
            }
            break;
        case '.':
            j=resultString.length();
            break;
    }


    }
}