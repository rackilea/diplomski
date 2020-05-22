private void traverse(node p) 
{
   Traverse t = null;

    if (p.left)
       t = new Traverse(p.left);
    if (p->right)
       t = new Traverse(p.right)

    t.run();   // start thread. this call will not wait for run to finishes
}