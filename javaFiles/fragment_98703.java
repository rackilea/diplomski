private static <T> T getPage(Supplier<? extends T> supp) {
    T page = supp.get();
    PageFactory.initElements(driver, page);
    return page;
}

public static LoginPage Login() {
    return getPage(LoginPage::new); // Passing the default constructor
}