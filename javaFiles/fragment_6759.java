ReturnsANumber v = new ReturnsANumber() {
        int theNumber() {
            return 119;
        }

        public int getIt() {

            Supplier<Integer> supplier = this::theNumber;

            ReturnsANumber w = new ReturnsANumber() {
                int theNumber() {
                    return 1;
                }

                public int getIt() {
                    return supplier.get();
                }
            };

            return w.getIt();
        }
    };