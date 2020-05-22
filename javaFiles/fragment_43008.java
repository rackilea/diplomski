public interface EVisitResult {
}

public enum PublicEVisitResult implements EVisitResult {
  /** Continue without visiting the siblings of this node. */
  SKIPSIBLINGS,

  /** Continue without visiting the descendants of this node. */
  SKIPSUBTREE,

  /** Continue traversal. */
  CONTINUE,

  /** Terminate traversal. */
  TERMINATE,
}

enum LocalEVisitResult implements EVisitResult {
  /** Pop from the right sibling stack. */
  SKIPSUBTREEPOPSTACK
}