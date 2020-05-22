@Database(entities = {RippleModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

public abstract RippleModelDao rippleModelDao();

private static AppDatabase INSTANCE; //Used for the singleton

public static AppDatabase getDatabase(Context context) { //THIS LINE
    if (INSTANCE == null) {
        INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase.class, "ripple_db"
                    ).build(); //STACKTRACE SHOWS HERE
    }
    return INSTANCE;
}