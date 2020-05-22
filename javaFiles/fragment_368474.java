String storyText = story.getText().toString();
// ...
storyText = storyText + " " + "<b>" + field[y] + "</b>" + " ";
storyText.replaceAll("\n", "<br />");
spanned = Html.fromHtml(storyText);
story.setText(spanned);