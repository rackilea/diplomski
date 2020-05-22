@Singleton
public class UserRepository {

    private final RetrofitApi retrofitApi;
    private final AppDatabase appDatabase;

    @Inject
    UserRepository(RetrofitApi retrofitApi, AppDatabase appDatabase) {
        this.retrofitApi = retrofitApi;
        this.appDatabase = appDatabase;
    }

    public Observable<ApiResource<User>> getUser(long userId) {
        return new ApiRepositorySource<UserResponse, User>(appDatabase) {

            @Override
            protected boolean shouldFetch() {
                return true;
            }

            @NonNull
            @Override
            protected Flowable<User> loadFromDb() {
                return appDatabase.userDao().getUserFlowable(userId);
            }

            @NonNull
            @Override
            protected Observable<UserResponse> createCall() {
                return retrofitApi.getUserById(userId);
            }
        }.asObservable();
    }

}