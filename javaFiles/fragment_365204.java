public SomeViewModel(@NonNull Application application) {
    super(application);
    CustomApplication app = (CustomApplication) application;
    daoRepository = app.daoRepository();
    userLD = new MutableLiveData<>();

    firstLD = Transformations.switchMap(userLD, user -> daoRepository.getMostRecentGoalWeekly(user.getId()));

    secondLD = Transformations.switchMap(firstLD, first ->
            daoRepository.getAvgGradeRouteInPeriod(userId, first.getDateCreated(),first.getDateExpires()));
    thirdLD = Transformations.switchMap(firstLD, first ->
            daoRepository.getAvgGradeRouteInPeriod(userId, first.getDateCreated(),first.getDateExpires()));
    fourthLD = Transformations.switchMap(firstLD, first ->
            daoRepository.getAvgGradeRouteInPeriod(userId, first.getDateCreated(),first.getDateExpires()));

}