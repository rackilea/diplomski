foo.bar( baz, quux );

// ^   ^    ^    ^
// |   |    |    |
// |   |     \  /
// |   |      \/
// |   |       overload on the classes of these arguments
// |   |
// |    method name
// |
//  dispatch on this “argument”