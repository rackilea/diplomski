/**
 * Gets the recognizer class where the dependent parser rules are defined.
 * This may reference the generated parser class directly, or for simplicity
 * in certain cases, any class derived from it.
 * <p>
 * If this value is not specified, the default value {@link Parser}
 * indicates that the declaring type of the constant value specified for
 * {@link #rule} should be used as the recognizer type.
 * </p>
 */
Class<? extends Recognizer<?, ?>> recognizer() default Parser.class;