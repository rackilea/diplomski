class Links{
    private ArrayList<Link> links;
    // getter & setter
}

class Link {
    private String href;
    private String rel;
    private String method;
   // getter & setter
}

Gson gson = new Gson();
Links links = gson.fromJson(json, Links.class);

for(Link link:links.getLinks()){
    if(link.getRel().equals("approval_url")){
        System.out.println(link.getHref());
        break;
    }
}