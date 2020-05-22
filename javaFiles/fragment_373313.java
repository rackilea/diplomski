private static DbHelper myDbHelper;

public CheckClassroom() {
    super("CheckClassroom");
    ourContext = this;
    myDbHelper = new DbHelper();
}