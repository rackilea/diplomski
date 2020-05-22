public class Vaadinapplicationimpl1Application extends Application {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        setTheme("sample");
        setMainWindow(new Window() {{
                setCaption("Vaadin-Layouting Sample");
                setContent(new CssLayout() {{
                        addStyleName("workareacontainer");
                        setSizeFull();
                        addComponent(new TabSheet() {{
                                // If you set the width to "100%" the TabSheet will overflows the
                                // the green and red divs. Set this to 100% and add 
                                // "overflow-x:hidden" to the CSS if you don't care about
                                // the right margin  
                                setWidth("99%");

                                addTab(new VerticalLayout() {{
                                        setSpacing(true);
                                        Label l = new Label("Workarea");
                                        addComponent(l);
                                        addComponent(new HorizontalLayout() {{
                                                setSpacing(true);
                                                addComponent(new Button("Button 1"));
                                                addComponent(new Button("Button 2"));
                                            }
                                        });
                                    }
                                }, "First");
                            }
                        });
                    }
                });
            }
        });
    }
}