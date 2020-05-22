// Parent classes
abstract class Definition {}

abstract class FileImporter<T extends Definition> {
  protected List<T> definitions;

  public FileImporter(List<T> definitions) {
    this.definitions = definitions;
  }

  public void doSomething() {
    // use 'definitions'
  }
}

// Text files
class TextDefinition extends Definition {
  public void copyLine() {}
}

class TextFileImporter extends FileImporter<TextDefinition> {
  // here should be clear that 'definitions' is of type List<TextDefinition>
  // to call 'copyLine()' on its items
}

// XML files
class XmlDefinition extends Definition {
  public void copyNode() {}
}

class XmlFileImporter extends FileImporter<XmlDefinition> {
  // here should be clear that 'definitions' is of type List<XmlDefinition>
  // to call 'copyNode()' on its items
}