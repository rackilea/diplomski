String values = "acceikoquy";
String values2 = "achips";

//TODO: put true or false if you want to count duplicates or not
int result = sameCharsCount(values, values2, true); // <- returns 3

int withDups = sameCharsCount("aaba", "caa", true); // <- 2 (two 'a' are shared)
int noDups = sameCharsCount("aaba", "caa", false);  // <- 1 (just a fact, 'a' is shared)