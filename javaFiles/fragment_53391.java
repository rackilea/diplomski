void func2(int * pointer_to_value)
{
  *pointer_to_value = 16;
}
void caller()
{
  int number = 0;
  func2(&number);
  std::cout << "The value of number is: " << number << "\n";
}