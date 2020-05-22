try {
      assertTrue("Link button not found",isElementPresent(By.id("LinkButtonRegister")));
} catch (Error e) {
      //Add here any log message if necesary
      System.out.println("Link button not found");

      verificationErrors.append(e.toString());
}