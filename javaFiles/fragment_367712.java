Browser browser = new Browser(parent, SWT.NONE);
browser.addLocationListener(new LocationListener() {
    public void changing(LocationEvent event)
    {
        System.out.println("Navigating to: " + event.location);
    }

    public void changed(LocationEvent event)
    {
        System.out.println("Location is: " + event.location);
    }
});