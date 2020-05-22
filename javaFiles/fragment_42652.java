private void printBooks() {
        writer.formattedHeadings();
        writer.write("\n"); // <-- This is the first time
        List<Lendable> items = library.listItems();
        items.stream().filter(item -> item.isOfType(Book)).forEach(item -> {
            writer.write("\n" + item.toFormattedString());
        });
    }