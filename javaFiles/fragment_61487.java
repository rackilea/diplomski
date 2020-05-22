ChromeDriver driver = new ChromeDriver();
        driver.Navigate().GoToUrl("https://www.flashscore.com/");

        //works after the page is fully loaded.
        //goes to a bottom line.

        string href = driver.FindElementByXPath("//*[@id='lmenu_17']/ul/li[1]/a").GetAttribute("href"); // albanian link
        //driver.Navigate().GoToUrl(href);

        foreach (var element in driver.FindElements(By.XPath("//*[@id='lc']/div[6]/ul/li/a")))
        {
            Console.WriteLine(element.GetAttribute("href"));
        }

        driver.FindElementByXPath("//*[@id='lc']/div[6]/ul/li[12]/a").Click();
        Thread.Sleep(1000);

        foreach (var element in driver.FindElements(By.XPath("//*[@id='lc']/div[9]/ul/li/a")))
        {
            Console.WriteLine(element.GetAttribute("href"));
        }

        Console.ReadKey();