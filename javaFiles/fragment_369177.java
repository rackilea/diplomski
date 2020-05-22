func = (value) -> Optional.of(value + 5);
func = func.andThen((optionalValue) -> {
    // Instead of throwing an exception, return an empty Optional
    System.out.println("Log the failure");
    return Optional.empty();
});
func = func.andThen((optionalValue) -> {
    optionalValue.map((value) -> { // This lambda will only execute if optionalValue is not empty
        System.out.println("Reached last function !");
        return value; // map wraps this in an Optional
    });
});
// Finally, unwrap the value. Optional provides a number of ways to do this, depending on how you want to handle failure/empty
func = func.andThen((optional) -> optional.orElse(...));
executeFunction(func);