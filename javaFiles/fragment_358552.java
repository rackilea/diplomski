final Dialog dialog = new Dialog("Hi");
dialog.add(new Label("World"));
dialog.setBackCommand(new Command(""){

    @Override
    public void actionPerformed(ActionEvent evt) {
        dialog.dispose();
    }            
});
dialog.setDisposeWhenPointerOutOfBounds(true);
dialog.show();