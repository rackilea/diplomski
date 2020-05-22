tab.setOnCloseRequest(e -> {
                if (getEditorForTextArea(getTextAreaFor(tab)) != null){
                    textArea = getTextAreaFor(tab);
                    editor = getEditorForTextArea(textArea);
                    if (editor.isModified()){
                        if (DialogBox.newSaveConfirmationBox(tab.getText()))
                            saveFile();
                        else e.consume();
                    }
                }
            }
    );