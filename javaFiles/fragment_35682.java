public class App : MvxApplication
{
    public override void Initialize()
    {       
        RegisterCustomAppStart<AppStart>();
    }
}




    public class AppStart : MvxAppStart
{
    private readonly IAuthenticationService _authenticationService;

    public MvxAppStart(IMvxApplication application, IMvxNavigationService navigationService, IAuthenticationService authenticationService) : base(application, navigationService)
    {
        _authenticationService = authenticationService;
    }

    protected override void NavigateToFirstViewModel(object hint = null)
    {
        try
        {
            // You need to run Task sync otherwise code would continue before completing.
            var tcs = new TaskCompletionSource<bool>();
            Task.Run(async () => tcs.SetResult(await _authenticationService.IsAuthenticated()));
            var isAuthenticated = tcs.Task.Result;

            if (isAuthenticated)
            {
                //You need to Navigate sync so the screen is added to the root before continuing.
                NavigationService.Navigate<HomeViewModel>().GetAwaiter().GetResult();
            }
            else
            {
                NavigationService.Navigate<LoginViewModel>().GetAwaiter().GetResult();
            }
        }
        catch (System.Exception exception)
        {
            throw exception.MvxWrap("Problem navigating to ViewModel {0}", typeof(TViewModel).Name);
        }
    }
}