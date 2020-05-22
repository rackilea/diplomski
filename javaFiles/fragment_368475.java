SpannableString spannedStoryText = new SpannableString(story.getText());
// ...
String additionalStoryText = " " + "<b>" + field[y] + "</b>" + " ";
additionalStoryText.replaceAll("\n", "<br />"); // assuming you only want this for the appended text.
spannedStoryText = new SpannableString(TextUtils.concat(spannedStoryText, Html.fromHtml(additonalStoryText)));
story.setText(spannedStoryText);