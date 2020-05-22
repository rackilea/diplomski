display.asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        if (bar.isDisposed ())
                            return;
                        bar.setSelection(getProgress);
                    }
                });