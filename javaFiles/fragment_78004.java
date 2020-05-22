//****WORKS****
Object obj=items.get(i);
if(obj instanceof RSSItem){
    RSSItem rssItem = (RSSItem)obj;
    redditOutputTextView.append(rssItem .title + "\n");
}