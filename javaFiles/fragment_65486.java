class ExtendedSelectedTabChangeListener implements SelectedTabChangeListener{
        @Override
        public void selectedTabChange(SelectedTabChangeEvent event) {
            // clear old tables listeners
            if(currentTab != null){
                Component table = currentTab.getComponent();
                if(table instanceof EditTableInterface){
                    ((EditTableInterface) table).getTable().clearTableListeners();
                }
            }

            // add new listeners to new table
            currentTab = tabsheet.getTab(tabsheet.getSelectedTab());
            if(currentTab != null){
                Component table = currentTab.getComponent();
                if(table instanceof EditTableInterface){
                    ((EditTableInterface)table).getTable().setTableListeners();
                }
            }
        }

    }