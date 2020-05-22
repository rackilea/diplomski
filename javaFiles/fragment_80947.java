private void fixAfterDeletion(Node x)
{
    while ((x != root) && (colorOf(x) == NodeColor.BLACK))
    {
        if (x == leftOf(parentOf(x)))
        {
            Node sib = rightOf(parentOf(x));

            if (colorOf(sib) == NodeColor.RED)
            {
                setColor(sib, NodeColor.BLACK);
                setColor(parentOf(x), NodeColor.RED);
                rotateLeft(parentOf(x));
                sib = rightOf(parentOf(x));
            }

            if ((colorOf(leftOf(sib))  == NodeColor.BLACK) &&
                (colorOf(rightOf(sib)) == NodeColor.BLACK))
            ...