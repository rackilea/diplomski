doc = Jsoup.connect(BLOG_URL).get();
Elements nodeBlogStats = doc.select("#comunePartINI > option");
for(Element sezione : nodeBlogStats)
{
    titoli.add(sezione.text());
}