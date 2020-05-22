interface EraseableColoredPencil {

    void draw();

    default void erase() { ... }
}