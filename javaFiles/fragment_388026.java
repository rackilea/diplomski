final int iVal=i;
new Thread(new Runnable() {

    public void run() {
        try {

            runThread(classifierName, folder, path, dataFile, iVal, accuraciesList, dataSet);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}).start();