MutableStack<String> stack =
    Stacks.mutable.with("j", "i", "h", "g", "f", "e", "d", "c", "b", "a");

ListIterable<String> result = stack.pop(2);
Assert.assertEquals(Lists.mutable.with("a", "b"), result);

ArrayList<String> arrayList = stack.pop(4, new ArrayList<>());
Assert.assertEquals(Arrays.asList("c", "d", "e", "f"), arrayList);

Assert.assertEquals(Stacks.mutable.withReversed("g", "h", "i", "j"), stack);

MutableBag<String> bag = stack.pop(4, Bags.mutable.empty());
Assert.assertEquals(Bags.mutable.with("g", "h", "i", "j"), bag);

Assert.assertTrue(stack.isEmpty());