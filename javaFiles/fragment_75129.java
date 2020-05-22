static void Main(string[] args)
        {
            ChromeDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://play.google.com/store/apps/details?id=com.plokia.ClassUp&hl=en&showAllReviews=true");

            ExtractComments(driver);
            driver.Quit();
        }

        private static void ExtractComments(ChromeDriver driver,int startingIndex=0)
        {
            IEnumerable<IWebElement> comments = driver.FindElementsByCssSelector(@"div>span[jsname='bN97Pc']");

            if (comments.Count() <= startingIndex)
                return; //no more new comments hence return.

            if (startingIndex > 0)
                comments = comments.Skip(startingIndex); //skip already processed elements


            //process located comments
            foreach (var comment in comments)
            {
                string commentText = comment.Text;
                Console.WriteLine(commentText);
                (driver as IJavaScriptExecutor).ExecuteScript("arguments[0].scrollIntoView()", comment);
                Thread.Sleep(250);
                startingIndex++;
            }

            Thread.Sleep(2000); // Let more comments load once we have consumed existing
            ExtractComments(driver,startingIndex); //Recursively call self to process any further comments that have been loaded after scrolling
        }