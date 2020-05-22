@Test(priority = 1, groups = { "qty" })
    public void increaseQty() {
    System.out.println("in increase qty");
    }

    @Test(dependsOnMethods = { "increaseQty" }, groups = { "qty" })
    public void decreaseQty() {
    System.out.println("in decrease qty");
    }

    @Test(dependsOnGroups = { "qty" })
    public void removeFromCart() throws Exception {
    System.out.println("remove qty");
    }

    @Test(dependsOnMethods = { "removeFromCart" })
    public void emptyCart() throws InterruptedException {
    System.out.println("empty Cart");
    }