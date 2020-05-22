public class Activity1 : SlidingActivity
{
    int count = 1;

    public override void OnCreate(Bundle bundle)
    {
        base.OnCreate(bundle);

        // Set our view from the "main" layout resource

        SetContentView(Resource.Layout.Main);
        SetBehindContentView(Resource.Layout.menu);
        // Get our button from the layout resource,
        // and attach an event to it

        Button button = FindViewById<Button>(Resource.Id.MyButton);

        button.Click += delegate { button.Text = string.Format("{0} clicks!", count++); };
    }
}