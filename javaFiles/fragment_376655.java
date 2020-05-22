public interface Node<N extends Node<N>> {

  public N getParent();
  public void setParent(N parent);

  public Collection<N> getChildren();

  public void addChild(N node);
  public void removeChild(N node);

  public N getRootNode();

  ... more ...
}

public abstract class ParentChildNode implements Node<ParentChildNode> {