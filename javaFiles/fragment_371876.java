for (WebElement e : allAvailsbleMarkets)
    for (String txt : ordinaryTimeTranslations) {
        if(txt.equals(e.getText())) {
            // Match found
            break;
        }
}