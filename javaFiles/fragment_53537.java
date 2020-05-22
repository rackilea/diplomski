public void replaceNameField(JPanel newNamePanel) {
     MigLayout layout = (MigLayout) pane.getLayout();
     Object constraintsForNamePanel = layout.getComponentConstraints(this.namePanel);
     pane.remove(this.namePanel);

      this.namePanel = newNamePanel;
      pane.add(newNamePanel, constraintsForNamePanel);
    }