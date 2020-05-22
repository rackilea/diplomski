if(localName.equals("item")){inItem = true;}
        if(inItem){
            if(localName.equals("title")){inTitle = true;}
            if(localName.equals("description")){inDescription = true;}
            if(localName.equals("pubDate")){inDate = true;}
            if(localName.equals("enclosure")){
                String url = attr.getValue(0);
                getBitmap(url);
            }
        }