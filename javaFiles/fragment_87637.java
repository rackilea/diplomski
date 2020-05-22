public HuffmanTree(T dataPortion, HuffmanTree<T> leftChild,
                           HuffmanTree<T> rightChild)
{
    data = dataPortion;
    left = leftChild;
    right = rightChild;
} // end constructor