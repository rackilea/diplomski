grid.addSelectionListener(event -> {
        if (event.getSelected().isEmpty()) {
            form.setVisible(false);
        } else {
            Item item = assetContainer.getItem(event.getSelected().iterator().next());
            form.setCustomer(item);
        }
    });