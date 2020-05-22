public abstract class Enum<E extends Enum<E>>
    implements Comparable<E>, Serializable {

    // [...]

    /**
     * Returns true if the specified object is equal to this
     * enum constant.
     *
     * @param other the object to be compared for equality with this object.
     * @return  true if the specified object is equal to this
     *          enum constant.
     */
    public final boolean equals(Object other) { 
        return this==other;
    }


}