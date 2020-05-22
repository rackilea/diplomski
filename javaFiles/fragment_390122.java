// get the shadowHost in the original dom using findElement
WebElement shadowHost = driver.findElement(By.cssSelector("shadowHost_CSS"));
// get the shadow root
WebElement shadowRoot = getShadowRoot(driver,shadowHost);
// access shadow tree element
WebElement shadowTreeElement = shadowRoot.findElement(By.cssSelector("shadow_tree_element_css"));