public class MButton extends Button {
    String mText;
    public MButton( Context context, AttributeSet attrs ) {
        super( context, attrs );
        loadText( context, attrs );
    }
    public MButton( Context context, AttributeSet attrs, int defStyle ) {
        super( context, attrs, defStyle );
        loadText( context, attrs );
    }
    void loadText( Context context, AttributeSet attrs ) {
        String stringId = attrs.getAttributeValue( "http://schemas.android.com/apk/res/android", "text" );
        // stringId = @2130903040
        int intStringId = Integer.parseInt( stringId.substring( 1 ));
        // intStringId = 2130903040
        mText = PreferenceManager.getDefaultSharedPreferences( context ).getString( stringId, context.getString( intStringId ));
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setText( mText );
    }
}