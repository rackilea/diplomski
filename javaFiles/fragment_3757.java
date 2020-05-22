List<Node>nods = doc.childNodes();
         for (Node node : nods) {
            if (node instanceof DocumentType) {
                DocumentType documentType = (DocumentType)node;
                  System.out.println(documentType.toString());
                  System.out.println(DocumentType.attr("publicid"));
            }
        }