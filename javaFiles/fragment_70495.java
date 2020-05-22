DOM.sinkEvents(editTD, com.google.gwt.user.client.Event.ONCLICK);
                                        DOM.setEventListener(editTD, new EventListener(){
                                            @Override
                                            public void onBrowserEvent(
                                                    com.google.gwt.user.client.Event event) {
                                                if (event.getTypeInt() != com.google.gwt.user.client.Event.ONCLICK) {
                                                    return;
                                                }
                                                Window.alert("Edit");
                                            }});