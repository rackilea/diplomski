d.setAddressCode(Optional.ofNullable(a)
                         .map(A::getbList)
                         .map(MyUtils::getFirst)
                         .map(B::getcList)
                         .map(MyUtils::getFirst)
                         .map(C::getValue)
                         .orElse(null));