interface Formatter {}

// Designates a formatter to pretty-print the annotated class
@interface PrettyPrinter {
    Class<? extends Formatter> value();
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^------------ Here
}