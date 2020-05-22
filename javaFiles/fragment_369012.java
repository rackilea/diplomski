LinkedHashMap<Pair, Element> combined = tauxPeriodesATDtos.stream().collect( 
       Collectors.toMap( (element) -> Pair.of( element.getDateDebut(), element.getDateFin()), //create the key
                         Function.identity(), //just use the new element
                         (e,n) -> { e.setTauxPrimeAT( e.getTauxPrimeAT().add( n.getTauxPrimeAT() ); return e; }, //combine the elements and return the existing one
                         LinkedHashMap::new ) ); //use a LinkedHashMap

List<TauxPeriodesATDto> resultList = new ArrayList<>( combined.values() );