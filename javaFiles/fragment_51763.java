List<Integer> numbersInToyClassList = ListUtil.map(
    new Function<ToyClass, Integer>(){
         public Integer map(ToyClass toy){
             return toy.number;
         }
    }, toyClassList);