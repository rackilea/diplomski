PopupMenu pm = new PopupMenu(MainActivity.this, pBtn);
    pm.getMenuInflater().inflate(R.menu.popup_menu, pm.getMenu());
    pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.first:
                    Toast.makeText(MainActivity.this, "Clicked First Menu Item", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.second:
                    Toast.makeText(MainActivity.this, "Clicked Second Menu Item", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.third:
                    Toast.makeText(MainActivity.this, "Clicked Third Menu Item", Toast.LENGTH_SHORT).show();
                    return true;
            }

            return true;
        }
    });
    pm.show();