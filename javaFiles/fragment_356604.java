List<T> oldList = ...
List<T> newList= ...

List<T> removed = new ArrayList<T>(oldList);
removed.removeAll(newList);

List<T> same = new ArrayList<T>(oldList);
same.retainAll(newList);

List<T> added = new ArrayList<T>(newList);
added.removeAll(oldList);