public static void main(String[] args) {
    Farm<?> farm = new Farm<>();
    farm
        .animal()
            .cat()
                .meow()
                .findsHuman()
                    .saysHello()
                    .done()
                .done()
            .dog()
                .bark()
                .chacesCar()
                .findsHuman()
                    .saysHello()
                    .done()
                .done()
            .done()
        .human()
            .saysHello()
            .done();

    Human human = new Human()
            .saysHello();
}