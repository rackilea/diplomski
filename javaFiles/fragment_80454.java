Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

    Element root = doc.createElement("catalogue");
    doc.appendChild(root);

    Element books = doc.createElement("books");
    root.appendChild(books);

    Element book1 = doc.createElement("book");
    book1.setAttribute("id", "1");
    books.appendChild(book1);

    Element book1_name = doc.createElement("name");
    book1_name.setTextContent("Gone with the wind");
    book1.appendChild(book1_name);

    Element book1_quantity = doc.createElement("quantity");
    book1_quantity.setTextContent("2");
    book1.appendChild(book1_quantity);

    Element book2 = doc.createElement("book");
    book2.setAttribute("id", "2");
    books.appendChild(book2);

    Element book2_name = doc.createElement("name");
    book2_name.setTextContent("Call of the wind");
    book2.appendChild(book2_name);

    Element book2_quantity = doc.createElement("quantity");
    book2_quantity.setTextContent("3");
    book2.appendChild(book2_quantity);

    Element book3 = doc.createElement("book");
    book3.setAttribute("id", "3");
    books.appendChild(book3);

    Element book3_quality = doc.createElement("quality");
    book3_quality.setTextContent("Good");
    book3.appendChild(book3_quality);