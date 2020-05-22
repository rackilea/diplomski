void func4(int * & pointer_to_value)
{
  pointer_to_value = new int;
  *pointer_to_value = 17;
}
void caller4()
{
  int * pointer_to_number;
  func4(pointer_to_number);
}