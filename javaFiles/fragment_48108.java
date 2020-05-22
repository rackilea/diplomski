IndexHits<Node> allArticles = nodeIndex.query( "*:*" );
... do stuff ...
allArticles.close();

or

Node myArticle = nodeIndex.get( "name", "MyArticle" ).getSingle();