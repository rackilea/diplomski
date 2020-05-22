public static List<String> findAllLinks(WebDriver driver) {

        // Declare finalList as string.
        List<String> finalList = new ArrayList<>();

        // Get the a tags
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        // get the img tags
        elementList.addAll(driver.findElements(By.tagName("img")));

        for (WebElement element : elementList) {
            // a tags have "href", img tags have src
            String link = element.getTagName().equalsIgnoreCase("a") ? element.getAttribute("href")
                    : element.getAttribute("src");
            // Check if link is not null and whether is a valid link by checking
            // starts with http or https
            if (link != null && (link.startsWith("http://") || link.startsWith("https://"))) {
                finalList.add(link);
            }
        }
        return finalList;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.gecko.driver",
                "E:\\Softwares\\gecko\\geckodriver-v0.16.1-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://testsite.com");
        List<String> allLinks = findAllLinks(driver);

        System.out.println("Total number of elements found " + allLinks.size());
        driver = new ChromeDriver();
        URI uri = null;
        for (String link : allLinks) {
            if (!driver.getCurrentUrl().equals(link)) {
                driver.manage().deleteAllCookies();
                driver.get(link);

                Thread.sleep(500);

                System.out.println(link);
                uri = new URI(driver.getCurrentUrl());
                try {
                    if (uri.getHost().equalsIgnoreCase("SpecificDomain.net")) {
                        System.out.println("Redirected URL-->> " + link);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }