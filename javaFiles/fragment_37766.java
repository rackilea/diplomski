// workaround if redesign is not possible
// NOT RECOMMENDED!

@Override public static void someMethod() {
    throw new RuntimeException(new CustomException());
}

//...
try {
    someMethod();
} catch (RuntimeException e) { // not catch(CustomException e)

    if (e.getCause() instanceof CustomException) {
        handleCustomException((CustomException) e.getCause());
    } else {
        throw e; // preserves previous behavior
    }

}