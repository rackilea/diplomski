if (result == JOptionPane.OK_OPTION) {
           for (PlayerEditorPanel.FieldTitle fieldTitle : PlayerEditorPanel.FieldTitle
                 .values()) {
              textArea.append(String.format("%10s: %s%n",
                    fieldTitle.getTitle(),
                    playerEditorPanel.getFieldText(fieldTitle)));
           }
        }