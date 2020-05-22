for (int i = 0; i < list.size(); i++) {

        Button button = new Button("test"); // OR
        Button button = new Button(list.get(i));
        form.add(button);
 };