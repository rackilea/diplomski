List<Expenses> expenses = map.get(type);
// Does the map have a List for type?
if (expenses == null) {
  // No. Add one.
  expenses = new ArrayList<>();
  map.put(type, expenses);
}
Expenses e = new Expenses(type, amount, year, month, date);
expenses.add(e);