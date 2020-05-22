private static final Factory spannableFactory = Spannable.Factory
        .getInstance();

private static final Map<Pattern, Integer> emoticons = new HashMap<Pattern, Integer>();

static {
    addPattern(emoticons, ":)", R.drawable.happy);
    addPattern(emoticons, ":(", R.drawable.sad);
    addPattern(emoticons, ":D", R.drawable.very_happy);
    // ...as many pattern you want. But make sure you have images in drawable directory
}

private static void addPattern(Map<Pattern, Integer> map, String smile,
        int resource) {
    map.put(Pattern.compile(Pattern.quote(smile)), resource);
}

public static boolean addSmiles(Context context, Spannable spannable) {
    boolean hasChanges = false;
    for (Entry<Pattern, Integer> entry : emoticons.entrySet()) {
        Matcher matcher = entry.getKey().matcher(spannable);
        while (matcher.find()) {
            boolean set = true;
            for (ImageSpan span : spannable.getSpans(matcher.start(),
                    matcher.end(), ImageSpan.class))
                if (spannable.getSpanStart(span) >= matcher.start()
                        && spannable.getSpanEnd(span) <= matcher.end())
                    spannable.removeSpan(span);
                else {
                    set = false;
                    break;
                }
            if (set) {
                hasChanges = true;
                spannable.setSpan(new ImageSpan(context, entry.getValue()),
                        matcher.start(), matcher.end(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }
    return hasChanges;
}

public static Spannable getSmiledText(Context context, CharSequence text) {
    Spannable spannable = spannableFactory.newSpannable(text);
    addSmiles(context, spannable);
    return spannable;
}