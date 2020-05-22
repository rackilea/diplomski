// Error! X does not implement Serializable, so this is not allowed
Y<? extends Serializable> obj = new Y<X>();

class Z extends X implements Serializable { ... }

// No problem, since Z extends X and also implements Serializable
Y<? extends Serializable> obj = new Y<Z>();