Document document = node.getDocument();

  node.detach();

  XMLWriter writer = new XMLWriter(new FileWriter(document.getPath() + document.getName()), OutputFormat.createPrettyPrint());
  writer.write(document);
  writer.close();