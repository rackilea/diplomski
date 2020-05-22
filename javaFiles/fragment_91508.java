@Test
public void add_a_user_to_the_system() {

    Actor ada = Actor.named("Ada").describedAs("an admin");

    when(ada).attemptsTo(
            AddANewUser.called("Jack")
    );

    then(ada).should(
            seeThat(KnownUsers.inTheSystem(),
                    contains(hasProperty("name", equalTo(("Jack"))))
            )
    );
}