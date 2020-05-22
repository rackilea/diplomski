"No, there is no way to hide the console window of the chromedriver.exe \\n"
                + "in the .NET bindings without modifying the bindings source code. This is seen \\n"
                + "as a feature of the bindings, as it makes it very easy to see when your code \\n"
                + "hasn\\'t correctly cleaned up the resources of the ChromeDriver, since the console window \\n"
                + "remains open. In the case of some other languages, if your code does not properly clean up \\n"
                + "the instance of ChromeDriver by calling the quit() method on the WebDriver object, \\n"
                + "you can end up with a zombie chromedriver.exe process running on your machine.";