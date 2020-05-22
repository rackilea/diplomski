while (it.hasNext() {
  TestClass current = it.next(); 

  if (current.getFoo() == 2)
    it.remove();
}