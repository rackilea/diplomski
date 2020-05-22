verify(mock, times(5)).someMethod("was called five times");
verify(mock, never()).someMethod("was never called");
verify(mock, atLeastOnce()).someMethod("was called at least once");
verify(mock, atLeast(2)).someMethod("was called at least twice");
verify(mock, atMost(3)).someMethod("was called at most 3 times");
verify(mock, atLeast(0)).someMethod("was called any number of times"); // useful with captors
verify(mock, only()).someMethod("no other method has been called on the mock");