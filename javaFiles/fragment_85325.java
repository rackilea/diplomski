s.scan(new Message<Integer>(), (a, b) -> a.append(b))
        .filter(Message::isComplete)
        .map(Message::fullMessage)
        .map(Optional::get).subscribe(v -> {
            System.out.println(v);
        });

    s.onNext(value(12));
    s.onNext(value(13));
    s.onNext(marker());// [V(12), V(13), MARKER]

    s.onNext(value(10));
    s.onNext(value(7));
    s.onNext(marker()); // [V(10), V(7), MARKER]



    s.onNext(value(10));
    s.onNext(value(127));

    s.onComplete(); // Not emitting incomplete messages on the closing of the subject.