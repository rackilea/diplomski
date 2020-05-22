int result = IntStream
                 .concat( 
                         IntStream.range( startIndex, list.size() ), 
                         IntStream.range(0, startIndex) )
                 .filter( i -> list.get(i).isOption() )
                 .findFirst()
                 .orElse(-1);