Foo foo = Mock()

foo.makeBar(_) >> { String id ->
    Bar bar = Mock()
    bar.getId() >> id
    bar
}