Future<SearchResult1> fut1=service1.search(params);

Future<SerchResult2> fut2 = service2.search(params);

model.addAttribute("list1", fut1.get());

model.addAttribute("list2", fut2.get());