class WelcomePage {

    @FindBy(partialLinkText = "Books")
    private WebElement books;
    .... // everything else

    void populateCatalogue() {
        // use 'books' here
    }
}