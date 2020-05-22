public BaseView clickOnReviewTab(String tabName){

    switch (tabName) {

    case "Treatment Reviews":
        tab("TREATMENT REVIEWS").click();
        return new ReviewsPage(driver);

    case "Videos & Guides":
        tab("VIDEOS & GUIDES").click();
        return new VideosPage(driver)'
    }
    return null; // or whatever
}