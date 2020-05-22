void func3(int * * pointer_to_point_to_value)
{
  *pointer_to_pointer_to_value = new int;
  **pointer_to_pointer_to_value = 23;
}
void caller3()
{
  int * pointer_to_number;
  func3(&pointer_to_number);
  cout << "Number is: " **pointer_to_number << "\n";
}