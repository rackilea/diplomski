list.add(i); // suppose that list had 1 element. After adding 1,
                         // it has two elements
            queue.addLast(list); // here you add the list with 2 elements to
                                 // the queue
            list.remove(list.size() - 1); // here you remove the added element
                                          // so the list you just added
                                          // to the queue has just 1 element