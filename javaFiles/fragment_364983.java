String at = "123123";
int count = 0; // Move out
for (int i = 0; i < at.length(); i++) {
  if (at.charAt(i) == '1'){ // Compare with the char '1'
    count++;
  }
}
// count is 2 here.