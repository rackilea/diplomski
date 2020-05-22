public interface Seqable {
    ISeq seq(); // returns an ISeq instance
}

public interface IPersistentCollection extends Seqable {
    // returns the count of this coll
    int count();
    // returns a new coll with o cons'd onto it
    IPersistentCollection cons(Object o);
    // returns a new empty coll (of same type?)
    IPersistentCollection empty();
    // compares this coll against o for equality
    boolean equiv(Object o);
}

public interface ISeq extends IPersistentCollection {
    // returns the first item in this seq
    Object first();
    // returns a new seq of every item in this except the first
    ISeq next();
    // returns a new seq of every item in this except the first
    // ASeq returns empty for empty
    ISeq more();
    // returns a new seq with o cons'd onto this seq
    ISeq cons(Object o);
}