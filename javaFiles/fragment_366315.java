final HTMLPanel container = new HTMLPanel("Test");
container.getElement().setId("someid");

container.addAttachHandler(new Handler() {

    @Override
    public void onAttachOrDetach(AttachEvent event) {
        initWave(container.getElement().getId());
    }});

RootPanel.get().add(container);