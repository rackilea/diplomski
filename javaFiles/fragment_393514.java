@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ...
    Typeface font = Typeface.createFromAsset(getAssets(), "fonts/choco.ttf");  
    ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content).getRootView();
    applyFontRecursively(rootView, font);
}

void applyFontRecursively(ViewGroup parent, Typeface font) 
{    
    for(int i = 0; i < parent.getChildCount(); i++)
    {
        View child = parent.getChildAt(i);            
        if(child instanceof ViewGroup) 
        {
            applyFontRecursively((ViewGroup)child, font);
        }
        else if(child != null)
        {
            Log.d("menfis", child.toString());
            if(child.getClass() == TextView.class)
            {
                ((TextView) child).setTypeface(font);
            }
        }                
    }
}