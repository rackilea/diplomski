for (int i=0;i<145;i++) {
      addListener(jLAL.get(i));
    }
  }

  private void addListener(final JLabel jLabel) {
    jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt, jLabel);
      }
    });
  }