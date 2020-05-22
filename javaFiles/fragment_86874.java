reverse(e1); // current points e1
{
  if(current == null || current.next == null) // false
  {
    return current; // not executed
  }
  Node rest = reverse(current.next); // recursion, here current points e2
  {
    if(current == null || current.next == null) // false
    {
      return current; // not executed
    }
    Node rest = reverse(current.next); // recursion, here current points e3
    {
      if(current == null || current.next == null) // true
      {
          return current; // returns current that points e3
      }
      current.next.next = current; // not executed
      current.next = null; // not executed
      return rest; // not executed
    } // end of recursion
    // now rest points e3 (the "if" above was true, returning current)
    // current is e2 again
    current.next.next = current; // e2.next.next (this is e3.next) = e2
    current.next = null; // e2.next points nothing
    return rest; // return e3 (rest points e3)
  } // end of recursion
  // now rest points e3
  // current points e1 again
  current.next.next = current; // e1.next.next (this is e2.next) = e1
  current.next = null; // e1.next points nothing
  return rest; // return a pointer to e3
}