MenuSheetView menuSheetView = new MenuSheetView(MenuActivity.this, MenuSheetView.MenuType.LIST, "Create...", new MenuSheetView.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (bottomSheetLayout.isSheetShowing()) {
                bottomSheetLayout.dismissSheet();
            }
            // do something
            return true;
        }
    });
menuSheetView.inflateMenu(R.menu.create);
bottomSheetLayout.showWithSheetView(menuSheetView);