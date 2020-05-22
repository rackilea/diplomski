Promise<Result> resultPromise = request.post("key=" + value).map(response -> {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    ByteArrayInputStream stream = new ByteArrayInputStream(response.getBody().getBytes("euc-jp"));
    String name = XPath.selectText("//name", builder.parse(stream)));
    System.out.println("name :" + name);

    return ok(main.render());
  });