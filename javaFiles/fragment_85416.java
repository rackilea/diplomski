projectNameTextCombo.addSelectionChangedListener(new ISelectionChangedListener() {
        public void selectionChanged(SelectionChangedEvent event) {
            IStructuredSelection selection = (IStructuredSelection) event
                    .getSelection();
            selectedProjectCombo = (Project) selection.getFirstElement();
            if (selectedProjectCombo != null) {
                updateEditionElements(selectedProjectCombo);
            }
            else {
                // Select the 0 position element
                projectNameTextCombo.getCombo().select(0);
                //Get the 0 element project of the comboviewer
                selectedProjectCombo = (Project) projectNameTextCombo.getElementAt(0);
                //If it is not null, update composite labels, else show information label
                if(selectedProjectCombo != null){
                    updateEditionElements(selectedProjectCombo);
                }else{
                    projectCreatedComposite.setVisible(false);
                    projectNotCreatedComposite.setVisible(true);
                    st.topControl = projectNotCreatedComposite;
                }
            }
        }
    });