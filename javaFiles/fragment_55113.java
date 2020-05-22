URIBuilder builder = new URIBuilder("https://api.fantasydata.net/soccer/v2/json/CompetitionDetails/EPL");
URI uri = builder.build();
HttpGet request = new HttpGet(uri);
request.setHeader("Ocp-Apim-Subscription-Key", "****************");
HttpResponse response = httpclient.execute(request);
HttpEntity entity = response.getEntity();

if (entity != null) 
{
    System.out.println(EntityUtils.toString(entity));
}