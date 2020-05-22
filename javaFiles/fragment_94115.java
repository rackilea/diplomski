// First we have a pointer to a node containing element (elm) 
// with possible a next element.
// Graphically drawn as:
// p -> [elm] -> ???

tmp = new Node();
// A new node is created. Variable tmp points to the new node which 
// currently has no value.
// p   -> [elm] -> ???
// tmp -> [?]

tmp.element = p.element;

// The new node now has the same element as the original.
// p   -> [elm] -> ???
// tmp -> [elm]

tmp.next = p.next;

// The new node now has the same next node as the original.
// p   -> [elm] -> ???
// tmp -> [elm] -> ???

p.element = y;

// The original node now contains the element y.
// p   -> [y] -> ???
// tmp -> [elm] -> ???

p.next = tmp;

// The new node is now the next node from the following.
// p   -> [y] -> [elm] -> ???
// tmp -> [elm] -> ???