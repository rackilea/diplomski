for(WebElement country : listOfCountries)
{
    log(country.getText()); //log is a another function executing System.out.println
    country.click(); //clicking on the web element

    Thread.Sleep(500);
    country.submit(); // submitting the element

  // You have to reselect this element. Because doesn't make sense anymore.
  // Try reselect next element
    arrowDownButton.click(); //reselecting the drop-down menu -> Why isn't this working?