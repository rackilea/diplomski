import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

list = list.stream().sorted(
                        comparing(AClass::getSeq1)
                       .thenComparing(reverseOrder(comparing(AClass::getSeq2))))
                       .collect(toList());


//or you could also write:

list = list.stream().sorted(
                        comparing(AClass::getSeq1)
                       .thenComparing(comparing(AClass::getSeq2).reversed()))
                       .collect(toList());