CompareChoice choice = CompareChoice.SIZE;

Path path1 = fileOfSize(1, TB);
Path path2 = fileOfSize(3, TB);

Path naturalOrderResult = CompareChoice.select(choice, path1, path2);
Path reversedOrderResult = CompareChoice.select(choice.reversed(), path1, path2);

assert path1 == naturalOrderResult;
assert path2 == reversedOrderResult;