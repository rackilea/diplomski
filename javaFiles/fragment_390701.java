final List<String> allStyleClasses = Arrays.asList("koItem", "naItem", "okItem");

// ...
                    @Override
                    public void updateItem(final String item, final boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            setAlignment(Pos.CENTER);
                            getStyleClass().removeAll(allStyleClasses);
                            switch (item) {
                                case "OK":
                                    getStyleClass().add("okItem");
                                    break;
                                case "N/A":
                                    getStyleClass().add("naItem");
                                    break;
                                case "KO":
                                    getStyleClass().add("koItem");
                                    break;
                                default:
                                    break;
                            }


                        } else {
                            setText(null);
                        }
                    }