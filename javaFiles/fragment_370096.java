Console.WriteLine("Creating GhostDriver (PhantomJS) driver.");
   //Temporary commented for testing purposes
   IWebDriver ghostDriver = new PhantomJSDriver("..\\..\\..\\MyFramework\\Drivers");
                ghostDriver.Manage().Window.Maximize();
                //ghostDriver.Manage().Window.Size = new Size(1920, 1080);
                ghostDriver.Manage()
                    .Timeouts()
                    .SetPageLoadTimeout(new TimeSpan(0, 0, 0,
                        Convert.ToInt32(ConfigurationManager.AppSettings["Driver.page.load.time.sec"])));
                return ghostDriver;