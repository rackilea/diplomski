try {
   doSomeStuff();
} catch (SomeException<Integer> e) {
   // ignore that
} catch (SomeException<String> e) {
   crashAndBurn()
}