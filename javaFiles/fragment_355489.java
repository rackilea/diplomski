j = i++ + i++ + ++i;
// first step, post increment
j = i++ + i++ + ++i;
//  ^^^
j = 1   + i++ + ++i;
// now, i is 2, and another post increment:
j = i++ + i++ + ++i;
//  ^^^^^^^^^
j = 1   + 2   + ++i;
// now, i is 3 and we have a pre increment:
j = i++ + i++ + ++i;
//  ^^^^^^^^^^^^^^^^
j = 1   + 2   +   4;
j = 7;