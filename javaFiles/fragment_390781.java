package node;

import java.util.List;

import javax.annotation.Nullable;

public interface WrappedNode {
  List<? extends WrappedNode> getChildElements(String namespaceUri, String localName);

  @Nullable
  WrappedNode getAttribute(String namespaceUri, String localName);

  @Nullable
  String getValue();
}