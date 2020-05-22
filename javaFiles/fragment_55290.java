List<MyEnum> list = new ArrayList<MyEnum>();
for (MyEnum value : MyEnum.values()) {
  if ((mask & (1 << value.ordinal())) != 0) {
    list.add(value);
  } 
}
return EnumSet.copyOf(list);