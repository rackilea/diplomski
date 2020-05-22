MyObject source = ...;
MyObject target = ...;

BeanUtils.copyProperties(source, target);
...
List<String> newList = new ArrayList<>(source.getList());
target.setList(newList);