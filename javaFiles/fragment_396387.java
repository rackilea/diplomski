//Menu button onClickListener
    menu_lilac.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            //create instance of PopupMenu
            PopupMenu popup = new PopupMenu(getApplicationContext(), view);
            //inflate menu with layout mainmenu
            popup.inflate(R.menu.mainmenu);
            popup.show();

            //Set on click listener for the menu
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId()== R.id.Home){
                        Toast.makeText(context, "At home!", Toast.LENGTH_LONG).show();
                    }
                    if (item.getItemId() == R.id.Tasks){
                        startActivity(toTasks);
                    }
                    if (item.getItemId() == R.id.Distractions){
                        startActivity(toDist);
                    }
                    if (item.getItemId() == R.id.Settings){
                        startActivity(toSett);
                    }
                    return false;
                }
            });
        }
    });