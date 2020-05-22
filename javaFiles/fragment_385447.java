Future<Integer> futureOfInt;
Future<?> futureOfSomething;
futureOfSomething = futureOfInt; // a future of int is a future of something

Pair<String, Future<String>> pairOfStringAndFutureOfString;
Pair<String, Future<?>> pairOfStringAndFutureOfSomething;

// pretend this is legal
pairOfStringAndFutureOfSomething = pairOfStringAndFutureOfString;

// danger!
pairOfStringAndFutureOfSomething.setRight(futureOfSomething);
Future<String> futureOfString = pairOfStringAndFutureOfString.getRight();

//sometime later...
String string = futureOfString.get(); //ClassCastException