verify(bookRepository, times(1)).saveAll(argThat(new ArgumentMatcher<List<Book>>() {
            @Override
            public boolean matches(Object argument) {
                List<Book> bookToCheck = (List<Book>) argument;
                assertThat(bookToCheck.get(0), sameAsBean(expectedBook));
                return true;
            }
        }));