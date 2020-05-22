final NativePreviewHandler nativeHandler = new NativePreviewHandler() {
                    @Override
                    public void onPreviewNativeEvent(NativePreviewEvent event) {

                    preventBack();

                        if (SessionFactory
                                .getValue(SesisonKey.CLIENT_SESSION_EXPIRED) != null) {
                            boolean expire = (Boolean) SessionFactory
                                    .getValue(SesisonKey.CLIENT_SESSION_EXPIRED);
                            if (expire) {
                                boolean show= false;
                                //logout session code
                                ClientSideTimers.renewSessionTimer();
                            }
                        }
                    }
                };
                Event.addNativePreviewHandler(nativeHandler);