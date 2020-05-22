private synchronized void updateHtmlEditor(final HTMLEditorKit editorkit, final StringReader reader)
  {
    Runnable runnable = new Runnable()
    {
      public void run() {
        try {
          editorkit.read(reader, htmlViewEditor.getDocument(), htmlViewEditor.getDocument().getLength());
        } catch (IOException ex) {
          Logger.getLogger(LinkParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
          Logger.getLogger(LinkParser.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    };
    SwingUtilities.invokeLater(runnable);
  }