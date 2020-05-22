for (int i = 0; i < itemsList.size(); i++) {
        final String item = itemsList.get(i);
        TButton button = new TButton("" + item, 8, 300 + (25 * i), 90, 25) {
            public void doAction() {
                System.out.println("Item: " + item);
                //TestGame.this.test = "" + item;
            }
        };
        this.framework.add(button);
    }