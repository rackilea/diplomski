ArrayList<Rectangle> blocks = getBlock();
ArrayList<Rectangle> done = getDone();

outer: for(int i = 0; i < blocks.size(); ++i)
{
    for(int j = 0; j < done.size(); ++j)
    {
        if(blocks.get(i).y == done.get(j).y + 40)
        {
            done.add(blocks.get(i));
            blocks.remove(i);
            --i; // Make sure you handle the change in index.
            create();
            continue outer; // Ugly solution, consider moving the logic of the inner for into an own method
        }
    }
}