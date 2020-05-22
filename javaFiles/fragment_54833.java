import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static one.util.streamex.MoreCollectors.first;
import static one.util.streamex.MoreCollectors.pairing;

// ...

Collection<MyOtherClass> result = 
    StreamEx.of(list)
            .groupingBy(
                MyClass::getStackId,
                pairing(
                    collectingAndThen(mapping(MyClass::getStackId, first()), Optional::get),
                    mapping(MyClass::getQuestionId, toList()),
                    MyOtherClass::new
                )
            ).values();