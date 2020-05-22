DefaultListModel dlm = (DefaultListModel) subjectList.getModel();

      if(this.subjectList.getSelectedIndices().length > 0) {
          int[] selectedIndices = subjectList.getSelectedIndices();
          for (int i = selectedIndices.length-1; i >=0; i--) {
              dlm.removeElementAt(selectedIndices[i]);
          } 
    }