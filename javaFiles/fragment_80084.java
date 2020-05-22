private IndexedContainer getTradParameters(int id){
        IndexedContainer container = new IndexedContainer();
        container.addContainerProperty("name", String.class, null);
        try {
            Document doc = Jsoup.connect("http://10.0.0.1:7474/db/data/node/"+id+"/").get();
            Elements properties = doc.select("th");
            for(int index = 0; index < properties.size(); index++){
                String parameter = properties.get(index).text();
                Item item = container.addItem(index);
                item.getItemProperty("name").setValue(parameter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }   
        return container;
    }