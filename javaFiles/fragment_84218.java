boolean foundAny = false;
 T result = null;
 for (T element : this stream) {
     if (!foundAny) {
         foundAny = true;
         result = element;
     }
     else
         result = accumulator.apply(result, element);
 }
 return foundAny ? Optional.of(result) : Optional.empty();