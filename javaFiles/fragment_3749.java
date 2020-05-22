@Test
    public void testCreateOnlyOnce() {
        Sut sut = spy(new Sut());
        sut.getData();
        sut.getData();
        sut.getData();
        verify(sut, times(1)).create();
    }

    private static class Sut {

        private Supplier<Object> data;

        // Added de data object initialization on the constructor to help debugging.
        public Sut() {
            this.data = this::create;
        }

        void getData() {
            data.get();
        }

        Object create() {
            return new Object();
        }
    }