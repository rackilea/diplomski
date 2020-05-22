SpannableStringBuilder ssb = new SpannableStringBuilder();

for (int i = 0;  i < contentJsonArray.length(); ++i) {
    JSONObject json = (JSONObject)contentJsonArray.get(i);
    ssb.append(json.getString(KEY_SOME_KEY));

    if (i == contentJsonArray.length() - 1)
        break;

    int start = ssb.length();
    ssb.append("( # )");
    ssb.setSpan(new ForegroundColorSpan(R.color.Red), start, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    ssb.setSpan(new AbsoluteSizeSpan(10, true), start, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
}

CalligraphyTypefaceSpan typefaceSpan =
        new CalligraphyTypefaceSpan(
                TypefaceUtils.load(getActivity().getAssets(),
                        "fonts/some_custom_font.ttf"));
ssb.setSpan(typefaceSpan, 0, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
textView.setText(ssb);