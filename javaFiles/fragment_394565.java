for (int i=0; i<lines; i++)
{
    tree t = new tree();
    t.line_no = i;

    // Create new array for each element
    line_segment line[] = new line_segment[n];

    t.line_segment = line;
    treeSet.add(t);
}