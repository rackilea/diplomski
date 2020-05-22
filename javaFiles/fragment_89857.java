/**
 * Visitor capable of visiting each node within a document.
 * The visitor contains a callback method for each node type
 * within the document.
 */
public interface DocumentNodeVisitor {
  void visitWord(Word word);
  void visitImage(Image img);
}

/**
 * Base interface for each node in a document.
 */
public interface DocumentNode {
  void applyVisitor(DocumentVisitor v);
}

/**
 * Conrete node implementation representing a word.
 */    
public class Word implements DocumentNode {
  private final String s;

  public Word(String s) { this.s = s; }

  public String getValue() { return this.s; }

  public void applyVisitor(DocumentVisitor v) {
    // Make appropriate callback to visitor.
    v.visitWord(this);
  }
}

/**
 * Conrete node implementation representing an image.
 */        
public class Image implements DocumentNode {
  public void applyVisitor(DocumentVisitor v) {
    // Make appropriate callback to visitor.
    v.visitImage(this);
  }
}

public class Paragraph implements DocumentNode {
  private final List<DocumentNode> children;

  public Paragraph() {
    this.children = new LinkedList<DocumentNode>();
  }

  public void addChild(DocumentNode child) {
    // Technically a Paragraph should not contain other Paragraphs but
    // we allow it for this simple example.
    this.children.add(child);
  }

  // Unlike leaf nodes a Paragraph doesn't callback to
  // the visitor but rather passes the visitor to each
  // child node.
  public void applyVisitor(DocumentVisitor v) {
    for (DocumentNode child : children) {
      child.applyVisitor(v);
    }
  }
}    

/**
 * Concrete DocumentVisitor responsible for spell-checking.
 */
public class SpellChecker implements DocumentVisitor
  public void visitImage(Image i) {
    // Do nothing, as obviously we can't spellcheck an image.
  }

  public void visitWord(Word word) {
    if (!dictionary.contains(word.getValue()) {
      // TODO: Raise warning.
    }
  }
}