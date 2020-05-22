System.out.println(byPrice);
// {10=[Item{color=yellow, price=10, size=1}, Item{color=green, price=10, size=2}], 42=[Item{color=green, price=42, size=4}], 4=[Item{color=black, price=4, size=4}]}
System.out.println(byPrice.values());
// [Item{color=yellow, price=10, size=1}, Item{color=green, price=10, size=2}, Item{color=green, price=42, size=4}, Item{color=black, price=4, size=4}]
System.out.println(byPrice.get(10));
//[Item{color=yellow, price=10, size=1}, Item{color=green, price=10, size=2}]