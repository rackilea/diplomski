final int difference;
if (first_var > second_var) {
  difference = first_var - second_var;
} else {
  difference = second_var - first_var;
}

// note: difference is in scope, and is definitely assigned here,
//       (and declared final)