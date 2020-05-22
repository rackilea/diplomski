private void rotateLeft(Word parent, Word child, Word grandChild)
{
    child = parent;
    child.setLeft(parent);
    child.setRight(grandChild);
}