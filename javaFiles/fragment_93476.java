String artistText = artistInfo.getWikiText();
Log.i("Log", artistText);
artistText = artistText.replaceAll("\n\r", "<br />");
artistText = artistText.replaceAll("\n", "<br />");
artistText = artistText.replaceAll("\r", "<br />");
System.out.println(artistText);
txtWiki.setText(Html.fromHtml(artistText));