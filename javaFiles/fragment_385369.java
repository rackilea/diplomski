public static void mobileAssessmentPage() {
    int q = SeleniumCommands.findElementsByCss(ASSESSMENTANSWER).count();

    List<WebElement> pageTitle;

    for (int i = 0; i < q; i++) {
        WebElement element = SeleniumCommands.findElementsByCss(ASSESSMENTANSWER)[i];
        element.click();
    }

    SeleniumCommands.waitClickById(ASSESSMENTNEXTPAGEBUTTON);
    try { Thread.sleep(500); } catch (InterruptedException ie) { ie.getMessage(); }
    pageTitle = SeleniumCommands.findElementsByXpath(PAGETITLE);
    try { Thread.sleep(500); } catch (InterruptedException ie) { ie.getMessage(); }
    System.out.println(pageTitle.get(0));
    if (pageTitle.size() > 0)
        if (pageTitle.get(0).getText().equals("Assessment"))
            mobileAssessmentPage();
}