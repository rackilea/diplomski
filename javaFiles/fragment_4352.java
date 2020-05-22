@Singleton
@Provides
@Named(Scope.FIREBASE)
public DataRepository provideFirebaseData(FirebaseDataRepository repo) {
    return repo;
}