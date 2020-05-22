System.out.println("your Col:");
for (Element element : colElements) {
    if (element.ownText().equalsIgnoreCase("CreateTime")) {
        System.out.print(element.text());
        for (Element sibling : element.siblingElements()) {
            System.out.print(", " + sibling.text());
        }
    }
    if (element.ownText().equalsIgnoreCase("CreateUser")) {
        System.out.print("\n"+element.text());
        for (Element sibling : element.siblingElements()) {
            System.out.print(", " + sibling.text());
        }
    }
}