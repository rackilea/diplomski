EasyMock.expect(mockObject.someMethod(anyObject()).andAnswer(
    new IAnswer<Integer>() {
        @Override
        public Integer answer() {
            return (Integer) EasyMock.getCurrentArguments()[0];
        }
    }
);