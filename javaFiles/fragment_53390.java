void func1(int& value)
{
  value = 5;
}
void another_function()
{
  int number = 0;
  func(number);
  std::cout << "The value of number is: " << number << "\n";
}