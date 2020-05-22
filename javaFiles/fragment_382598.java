// one taking a TreePath
public TreeModelEvent(Object source, TreePath path, int[] childIndices,
          Object[] children)

// the other taking an array of nodes to the root
public TreeModelEvent(Object source, Object[] path, int[] childIndices,
          Object[] children)

// mixture (**WRONG**)
TreeModelEvent event = new TreeModelEvent(this, 
    // this is an array with the path as single element
    new Object[] {rootNew.getPathForRow(3)}, // harcoding because i know i am deleting from dept2
    new int[]{1}, //hardcoding as i am removing emp4
    new Object[] {emp4});

// technically correct (but **don't** - TreeModelSupport does it for you :-) 
TreeModelEvent event = new TreeModelEvent(this, 
    // this is an array with the path as single element
    rootNew.getPathForRow(3), // harcoding because i know i am deleting from dept2
    new int[]{1}, //hardcoding as i am removing emp4
    new Object[] {emp4});