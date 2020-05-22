MenuItem menuItem = navigationView.getMenu().findItem(R.id.menu_item);
    SpannableString s = new SpannableString(menuItem.getTitle());
    s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance), 0, s.length(), 0);
      //for single item 
     if (menuItem.getItemId()==R.id.nav_targets){
              menuItem.setTitle(s);   
            }