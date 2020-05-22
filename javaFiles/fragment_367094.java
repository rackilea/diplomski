public class ButtonHandler implements OnClickListener,Runnable 
{
private String _data;//data to be passed for the button
private ArrayList<Integer> _resultId;//the id's of the text views
private Activity _activity;

public ButtonHandler(String data,ArrayList<Integer> resultId,Activity activity)
{
    _data=data;
    _resultId=resultId;
    _activity=activity;
}

@Override
public void run() 
{
     View currentView=_activity.findViewById(_resultId.get(Integer.valueOf(_data)));
     ScrollView scrollView=(ScrollView) _activity.findViewById(R.id.resultScroll);
     scrollView.scrollTo(0, currentView.getTop());

}

@Override
public void onClick(View v) 
{
    new Handler().post(this);

}

}