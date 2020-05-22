private List<Item> items = new AutoPopulatingList(
    new ElementFactory() {
        public Object createElement(int index) throws ElementInstantiationException {
             /**
               * Any removed item will be handled as null. 
               * So we just remove any nullable item before adding to our List
               * By using the following statement
               */
             items.removeAll(Collections.singletonList(null));

             return new Item();
        }
    });