d.setAddressCode(Optional.ofNullable(a)
                         .map(A::getbList)
                         .filter(bList -> ! bList.isEmpty())
                         .map(bList -> bList.get(0))
                         .map(B::getcList)
                         .filter(cList -> ! cList.isEmpty())
                         .map(cList -> cList.get(0))
                         .map(C::getValue)
                         .orElse(null));