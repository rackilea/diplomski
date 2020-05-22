public WebElement getElement(final int numOnPage) {
        return (WebElement) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[] { WebElement.class }, new InvocationHandler() {
            // Lazy initialized instance of WebElement
            private WebElement webElement;

            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                if (webElement == null) {
                    webElement = driver.findElement(By.id("element" + numOnPage));
                }
                return method.invoke(webElement, args);
            }
        });
    }