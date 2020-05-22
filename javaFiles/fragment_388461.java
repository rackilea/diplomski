public class MyClickableSpan extends ClickableSpan {
public interface SpanClickListener
{
     public void onSpanClicked(View widget, MyClickableSpan span);
}
private String word;
private SpanClickListener clickListener;

public MyClickableSpan(String word, SpanClickListener listener) {
    this.word = word;
    clickListener = listener;
}
public String getWord() { return word; }

@Override
public void onClick(View widget) {
        Log.d("Spaannnned",word);
        if (clickListener != null) clickListener.onSpanClicked(widget, this);
    }
}