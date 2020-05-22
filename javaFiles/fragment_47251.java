// These are just some constants
public static final String DB_NAME = "mydatabase";
private static final int DATABASE_VERSION = 1;
public static final String ApplicationPackage = "com.example.myapp";
public static final String DB_TABLE_ACCOUNTS = "accounts";

// This is the URI of the database table
public static final Uri DB_TABLE_ACCOUNTS_URI = Uri
            .parse("sqlite://" + Constants.ApplicationPackage + "/" + DB_TABLE_ACCOUNTS);