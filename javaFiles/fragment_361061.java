static Properties prop = null;
       public static void takeScreenShot(WebDriver driver, String className,
        String methodName) {

    try {

        prop = PropertiesLoader.getPropertiesLoader();
        File scrnsht=null;
        String isSequential = prop.getProperty("isSequential");
        if (isSequential.equalsIgnoreCase("true")) {
            scrnsht = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);


        } else {

            WebDriver augmentedDriver = new Augmenter().augment(driver);
            scrnsht = ((TakesScreenshot) augmentedDriver)
                    .getScreenshotAs(OutputType.FILE);

        }

            Calendar currentDate = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy/MMM/dd HH:mm:ss");
    String date = formatter.format(currentDate.getTime()).replace(
            "/", "_");
    String dateFormatetd = dateN.replace(":", "_");
    FileUtils.copyFile(scrnsht, new File(
            "D:\\SeleniumScreenShots\\" + className + "\\"
                    + methodName + dateFormatted + ".png"));