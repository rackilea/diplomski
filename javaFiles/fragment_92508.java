/*
 * On the first step, you delete 20.
 * So the list is [30, 40]
 *
 * On the second step, you delete at index 1
 * so you delete 40.
 *
 * Then i becomes > list.size() => the loop stops
 */
for (int i = 0; i < list.size(); i++) {
  System.out.println("deleted item: " + list.get(oldsize));
  list.remove(i);
}