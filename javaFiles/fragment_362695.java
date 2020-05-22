navigationDrawerLeft.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
            Intent intent = null;
            switch (position) {
                case 1:
                    intent = new Intent(MainFeed.this, EditProfil.class);
                    startActivity(intent);
                    break;
                default:
                    Log.d("Test","Default");
                    break;
            }
        }
    });