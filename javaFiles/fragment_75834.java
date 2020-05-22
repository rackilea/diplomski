new Mixer<Animal>(); // OR
new Mixer<Dog>();  // Dog extends Animal  // OR
new Mixer<Cat>();  // Cat extends Animal

// **** But NOT like this ******
new Mixer<Object>();  // Object does not extend Animal