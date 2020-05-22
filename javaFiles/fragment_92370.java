Elements classElements = document.getElementsByClass("CatalogusListDetailTextTitel");
            for (Element classElement : classElements) {
                if (classElement.text().contains("Productcode :")) {
                System.out.println(classElement.parent().ownText());
                }
            }