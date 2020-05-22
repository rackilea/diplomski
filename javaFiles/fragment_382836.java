private class EthnicityItemListener implements ItemListener {
        ArrayList selectedList;
        private EthnicityItemListener(ArrayList<String> selectedEthnicities) {
            this.selectedList = selectedEthnicities;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            //add or remove selected chk box text to the list based on 
            //selection state.
            if(e.getStateChange() == ItemEvent.SELECTED){
                this.selectedList.add(((JCheckBox)e.getSource()).getText());
            }else {
                this.selectedList.remove(((JCheckBox)e.getSource()).getText());
            }
            System.out.println(selectedList);
        }
    }