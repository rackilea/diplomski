if (textPaneHistory.getText().length() > 0){

            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(false);

            int option = chooser.showSaveDialog(ChatGUI.this);

            if (option == JFileChooser.APPROVE_OPTION) {

                StyledDocument doc = (StyledDocument)textPaneHistory.getDocument();

                HTMLEditorKit kit = new HTMLEditorKit();

                BufferedOutputStream out;

                try {
                    out = new BufferedOutputStream(new FileOutputStream(chooser.getSelectedFile().getAbsoluteFile()));

                    kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());

                } catch (FileNotFoundException e) {

                } catch (IOException e){

                } catch (BadLocationException e){

                }
            }
        }