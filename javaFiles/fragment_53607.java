Categoria catAtual = null;// your fix

while(eventType != XmlPullParser.END_DOCUMENT){

switch(eventType){

    case XmlPullParser.START_DOCUMENT:
        categorias = new ArrayList<Categoria>();
    break;

    case XmlPullParser.START_TAG:
        name = parser.getName();
        if("categoria".equalsIgnoreCase(name)){
            catAtual = new Categoria();
        } else if("nome".equalsIgnoreCase(name) && catAtual != null){
            catAtual.nome = parser.nextText();
        } else if("id".equalsIgnoreCase(name)  && catAtual != null){
            catAtual.id = parser.nextText;
        }
    break;

    case XmlPullParser.END_TAG:
        name = parser.getName();
        if(name.equalsIgnoreCase("categoria") && catAtual != null){
            categorias.add(catAtual);
        }
    break;

}

...