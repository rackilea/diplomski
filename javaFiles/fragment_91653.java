EasyMock.expect(mockObject.someMethod(EasyMock.capture(integerArgument)).andAnswer(
    new IAnswer<Integer>() {
        @Override
        public Integer answer() {
            return integerArgument.getValue(); // captured value if available at this point
        }
    }
);