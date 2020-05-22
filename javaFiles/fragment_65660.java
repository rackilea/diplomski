bool IsSpecialCharacter(char c)
{
  static special_chars[] = "~`!@#$%^&*()_+-=\\\/?><,.";
  char *p = &special_chars[0];
  while(*p) { 
   if(*p == c) return true;
  };
  return false;
}