File file = new File("game.xml");
JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
Root root = (Root) jaxbUnmarshaller.unmarshal(file);

for (int i = 0; i < root.getListGame().size(); i++) {
    System.out.println("Game Object "+(i+1));
    if(root.getListGame().get(i).getTextValue().size()>1){
        System.out.println("ID :"+root.getListGame().get(i).getId());
        System.out.println("Name :"+root.getListGame().get(i).getName());
        System.out.println("Translation :"+root.getListGame().get(i).getTranslation());
    }else{
        System.out.println("Value :"+root.getListGame().get(i).getTextValue().get(0));
    }
    System.out.println("------------------------------------");
}