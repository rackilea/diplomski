String[] arr =line.split("\\s+");
 SomeClass obj = new SomeClass();
 obj.setName(arr[0]);
 obj.setScore(Long.parseLong(arr[1]));
 obj.setAge(Integer.parseInt((arr[2]));
 list.add(obj);