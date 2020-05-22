function getImageURL(doc:NotesDocument, strRTItem,strFileType){
    if(doc!=null && !"".equals(strRTItem)){
        var rtItem = doc.getFirstItem(strRTItem);
        if(rtItem!=null){
            var personelDB = doc.getParentDatabase();
            var dbURL = getDBUrl(personelDB);
            var imageURL:java.lang.StringBuffer = new java.lang.StringBuffer(dbURL);

            if("file".equals(strFileType)){
                var embeddedObjects:java.util.Vector = rtItem.getEmbeddedObjects();
                if(!embeddedObjects.isEmpty()){
                    var file:NotesEmbeddedObject = embeddedObjects.get(0); 

                    imageURL.append("(lookupView)\\");
                    imageURL.append(doc.getUniversalID());
                    imageURL.append("\\$File\\");
                    imageURL.append(file.getName());
                    imageURL.append("?Open");

                }
            }else{              
                imageURL.append(doc.getUniversalID());
                imageURL.append("/"+strRTItem+"/");
                if(rtItem instanceof lotus.domino.local.RichTextItem){
                    imageURL.append("0.C4?OpenElement");
                }else{
                    imageURL.append("M2?OpenElement");
                }
            }
            return imageURL.toString()
        }
    }
}