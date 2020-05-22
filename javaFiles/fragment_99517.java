public void foo(SingletonInterface x) {
    // This code doesn't know it's a singleton. You can create fakes for testing.
}

...

// This code *does* know it's a singleton. Boo! Gradually refactor away...
foo(Singleton1.getInstance());