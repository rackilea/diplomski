package com.example;

public final class Type {

    public enum LeafType {
        STRING,
        INTEGER,
        BOOLEAN
    }

    //Gives you the familiar enum syntax
    public static final Type STRING = new Type(LeafType.STRING);
    public static final Type INTEGER = new Type(LeafType.INTEGER);
    public static final Type BOOLEAN = new Type(LeafType.BOOLEAN);

    private final LeafType leafType;

    private final Type listType;
    private final Object lock = new Object();
    // This is the cache that prevents creation of multiple instances

    private Type listOfMeType;

    private Type(LeafType leafType) {
        if (leafType == null) throw new RuntimeException("X");
        this.leafType = leafType;
        listType = null;
    }

    private Type(Type type) {
        leafType = null;
        listType = type;
    }

    /**
     * Get the type that represents a list of this type
     */
    public Type list() {
        synchronized (lock) {
            if (listOfMeType == null) {
                listOfMeType = new Type(this);
            }
            return listOfMeType;
        }
    }

    public boolean isList() {
        return listType != null;
    }

    /**
     * If this type is a list, will return what type of list it is
     */
    public Type getListType() {
        if (!isList()) {
            throw new RuntimeException("Not a list");
        }
        return listType;
    }

    /**
     * If this type is a leaf, will return what type of leaf it is
     */
    public LeafType getLeafType() {
        if (isList()) {
            throw new RuntimeException("Not a leaf");
        }
        return leafType;
    }

    @Override
    public String toString() {
        if (isList()) {
            return "LIST(" + getListType() + ")";
        }
        return getLeafType().toString();
    }
}