public class Scout  {
    public static void main(String[] args) {
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile profile = allProfiles.getProfile("SeleniumProfile");
        WebDriver driver = null;


        BufferedReader in = null;
        List<String> myList = new ArrayList<String>();
        try {   
            in = new BufferedReader(new FileReader("scoutLinks.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                myList.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String item : myList ){

            try {
                if(driver == null)
                {
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
                }
                driver.get(item);
            } catch (Exception e) 
            {
                System.out.println("Did not get url");
                driver.quit();
                driver = null;
            }

        }

    }
}