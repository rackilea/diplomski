boolean compareStacks(a, b) {
  if (a.isEmpty() != b.isEmpty()) return false; // check if one is empty
  if (a.isEmpty() && b.isEmpty()) return true; // check if both are empty
  element_a = a.pop(); // grab elements and compare them
  element_b = b.pop();
  if (((element_a==null) && (element_b!=null)) || !element_a.equals(element_b)) {
    a.push(element_a); // if they are not equal, restore them and return false
    b.push(element_b);
    return false;
  }
  result = compareStacks(a, b); // compare shortened stacks recursively
  a.push(element_a); // restore elements
  b.push(element_b);
  return result; // return result from recursive call
}