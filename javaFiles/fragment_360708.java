class LogGroup {

    private String Title;
    private String ID;

    public LogGroup(String Title, String ID) {
        this.Title = Title;
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof LogGroup)) {
            return false;
        }
        LogGroup logGroup = (LogGroup) o;
        return Objects.equals(Title, logGroup.Title) &&
               Objects.equals(ID, logGroup.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Title, ID);
    }
}