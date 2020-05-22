@FindBy(xpath = Constants.usersLink)
public WebElement usersLink;

    public UsersPage goToUsersPage() {
            JavascriptExecutor usersPage = (JavascriptExecutor) driver;
            usersPage.executeScript("arguments[0].click();", usersLink);
            return PageFactory.initElements(driver, UsersPage.class);
        }