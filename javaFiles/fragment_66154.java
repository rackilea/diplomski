@Retention(RetentionPolicy.RUNTIME)
@interface Command {
    String value();
}

@Command("drink")
class Drink implements Action {
    ...
}

@Command("look")
class Look implements Action {
    ...
}