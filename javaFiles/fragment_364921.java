try
{
            WebElement site_width_full_width = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("label[for=site_width-full_width]")));
            site_width_full_width.click();

            Thread.sleep(1000);
            System.out.println("FullWidth Label Found!");

        }
        catch (Exception e)
        {
            if (e instanceof NoSuchElementException)
            {
                System.out.println("FullWidth Label not found!");
                System.out.println(e);
            }
            else
            {
                System.out.println("Unexpected exception!");
                System.out.println(e);
            }
        }