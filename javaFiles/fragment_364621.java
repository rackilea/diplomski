@Database(entities = {Word.class}, version = 3)
@TypeConverters(DateConverter.class)
public abstract class WordDb extends RoomDatabase {

    private static WordDb INSTANCE;

    public abstract WordDao wordDao();

    static synchronized WordDb getInstance(Context contextPassed){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(contextPassed.getApplicationContext(),WordDb.class,"word_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}