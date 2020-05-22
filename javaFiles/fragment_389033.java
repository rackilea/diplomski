class SplashPresenter extends BasePresenter<SplashView> {

   private Scheduler mMainThread;

   private Scheduler mNewThread;

   private UserAuthService userAuthService;

  @Inject
  SplashPresenter(SplashView view, UserAuthService userAuthService, @Named(ValueConstants.NEW_THREAD) Scheduler newThread,  @Named(ValueConstants.MAIN_THREAD) Scheduler mainThread) {
        super(view);
        this.userAuthService = userAuthService;
        mNewThread = newThread;
        mMainThread = mainThread;
  }