public class KanjiTextView extends AppCompatTextView {
    public KanjiTextView(Context context) {
        super(context);
        updateFont();
    }

    public KanjiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        updateFont();
    }

    public KanjiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        updateFont();

    }

    public void updateFont()
    {
        int font_res = get_user_selected_font();

        Typeface typeface = getFont(getContext(), font_res.get_Res());
        setTypeface(typeface);
    }
}

_____________________________________________________________________________


      <com.[package].KanjiTextView
            android:id="@+id/TV_Kanjitext"
            android:text="学校"
            android:textAlignment="center"
            android:textSize="30sp"
            ...
            />