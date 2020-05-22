try {
        String TAG = "RandomGame";
        String[] imageArray =  {"bread.jpg","potatoe.jpg","eaters.jpg","earlobe.jpg","paintbrush.jpg"};
        int counterMax = imageArray.length;
        int[] indexUsageArray = new int[counterMax];
        // there are 2 copies of each image
        String[] imageToDisplayAtPosition = new String[2*counterMax];
        Random random;
        int randomIntTemp = 0;
        for (int i=0;i<counterMax;) { // only increase i AFTER completed attempt at randomization assignement
            random  = new Random();
            randomIntTemp = random.nextInt(2*counterMax);
            if (indexUsageArray[i] < 2) {
                //Log.w(TAG,"randomIntTemp:["+randomIntTemp+"] i:["+i+"] indexUsageArray[i]:["+indexUsageArray[i]+"] imageToDisplayAtPosition:["+imageToDisplayAtPosition[randomIntTemp]+"]");
                if (imageToDisplayAtPosition[randomIntTemp] ==  null) {
                    imageToDisplayAtPosition[randomIntTemp] = imageArray[i];
                    indexUsageArray[i]++;
                } // try another random position for same image
            } else { // assigned both positions, move to next image
                i++;
            }
        }
        Log.w(TAG,"Assignments");
        for (int j=0;j<2*counterMax;j++) {
            Log.w(TAG,"j:["+j+"] image:["+imageToDisplayAtPosition[j]+"]");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }