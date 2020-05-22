int i=0;

    while(i==0)
    {
        try{
            Select select = new Select(driver.findElement(By.xpath("ELEMENT_XPATH")));
            select.getOptions().indexOf(0);
            int ed = select.getOptions().indexOf(0);
            if(ed==0); //check whether it's got your index or not(if not then it will throw error and go to Catch section)
            {
                System.out.println("Pass got.. Index Value");
            }
            i=1; //if it got your index value in drop down then .. exit from loop..
        }catch(org.openqa.selenium.NoSuchElementException NSEE)
        {
            i=0; // iteration will continue until .. you'll not get your index in Drop down.. 
        }
    }