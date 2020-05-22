java.util.Collection<String> idToDelete =
        currentB.stream() //get the stream
        .filter(b -> !newA.contains(b.getA())) // filter those b, whose A is in newA
        .map(b -> b.getA().id) // map transform to get just an Id (you can use just getA() here)
        .collect(Collectors.toList()); // finally transform back to list

java.util.Collection<String> idToAdd =
        newA.stream() // again get stream
        .filter(
                // this is a little bit fancy...
                // only leave those A, for which currentB doesn't contain element, that has getA() equals to that A
                a -> currentB.stream().noneMatch(
                        b -> b.getA().equals(a)
                )
        )
        .map(a -> a.id) // again get id
        .collect(Collectors.toList()); // transform to list