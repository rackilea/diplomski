int difference;
if (first_var > second_var) {
  difference = first_var - second_var;
}
if (first_var < second_var) {
  difference = second_var - first_var;
}

// note: difference is not definitely assigned here!
//           (but at least it's in scope!)