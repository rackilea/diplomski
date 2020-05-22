void foo (List<String> list, ...) {
  ...
  for (String s : list) { // this is the only place where *list* is used
    ...
  }
  ...
}

void foo (String[] arr, ...) {
  if ( arr != null ) {
      foo(Arrays.asList(arr),...);
  }
}