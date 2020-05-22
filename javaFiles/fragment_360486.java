List<MyList> output = new ArrayList<>(lista.stream()
        .collect(Collectors.toMap(a -> a.getId1() + "-" + a.getId2(), a -> a, (myList1, myList2) -> {
            myList1.amountReserved = myList1.amountReserved + myList2.amountReserved;
            myList1.amountRequired = myList1.amountRequired - myList1.amountReserved;
            return myList1;
        })).values());