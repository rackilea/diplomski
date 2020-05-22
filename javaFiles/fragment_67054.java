for (; testParentPage != null; testParentPage = testParentPage.getParent()) {
    testPages.push(testParentPage);
    if(homePage != null && testParentPage.getPath().equals(homePage.getPath())){
        isParent = true;
        break;
    }
}