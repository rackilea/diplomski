Set<String> urlsVisited = new HashSet<String>();
...

String domain = new URI(url).getHost();
if(!urlsVisited.contains(domain))
{
    urlsToVisit.add(url);
    urlsVisited.add(domain); 
}