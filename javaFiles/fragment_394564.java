line_segment line[] = new line_segment[n];
for (int i=0; i<lines; i++)
{
    tree t = new tree();
    t.line_no = i;
    t.line_segment = line;
    treeSet.add(t);
}