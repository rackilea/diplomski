function x() {
  console.log("x called");
  return 42;
}

console.log("With else:");
if (x() > 1) {
  console.log("> 1");
} else if (x() < 1) {
  console.log("< 1");
}

console.log("Without else:");
if (x() > 1) {
  console.log("> 1");
}
if (x() < 1) {
  console.log("< 1");
}