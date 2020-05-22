interface News{}  //can be an abstract class

class NewsItem implements News{
}

class LatestNewsInfo implements News{
}

//edit - define variables to interface instead of actual implementation object 
List<News> allnewslist=new ArrayList<>();