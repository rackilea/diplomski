stream.forEach { println("A: $it") }
stream.forEach { println("B: $it") }

subject.onNext(1)

stream.forEach { println("C: $it") }
subject.onNext(2)
subject.onCompleted()