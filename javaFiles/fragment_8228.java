return invalidEx.stream()
   .map(ic -> {
          if(ic.getInvalidExcepType().equals(ExceptionType.TypeA)) {
              return (RuntimeException) new TypeAException(e);
          } else if (ic.getInvalidExcepType().equals(ExceptionType.TypeB)) {
              return (RuntimeException) new TypeBException(e);
          } else {
              return new TypeCException(e);
          }
    }).collect(Collectors.toList());