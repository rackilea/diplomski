given("some preconditions", () => {

    var range = 10;

    when("the system under test is ran", () => {

        var sut = new SystemUnderTest();

        bool score = arrange(() => sut.Fire(range));

        then("win!", () => {

            expect(() => score);
        });
    });
});