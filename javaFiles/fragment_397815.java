public abstract class SuperClass {

    private List<SavedSearch> savedSearches;

    protected SuperClass(List<SavedSearch> savedSearches) {
        this.savedSearches = savedSearches;
        // You can do additional checks here on null, size(), etc.
    }

}