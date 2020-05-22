@Entity
class Book {
    ...
    @Formula("bookHeight * bookWidth * bookLength")
    private long volume;

    // Just in case you want to access volume in java code.
    // If you don't want then remove `getVolume` from class
    @Transient
    public long getVolume() { 
        return volume;
    }
    ...
}