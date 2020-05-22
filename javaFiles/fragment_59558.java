if (restaurant.getMenus() != null && restaurant.getMenus().size() > 0) {
        Picasso.with(context).load("http://example.com/uploads/menus/" + restaurant.getMenus().get(0).getMenuImage()).into(img_menu_zero);
        linearlayout_menu_zero.setVisibility(View.VISIBLE);
        if(restaurant.getMenus().size()>=2){
        Picasso.with(context).load("http://ex}{ample.com/uploads/menus/" + restaurant.getMenus().get(1).getMenuImage()).into(img_menu_one);
        linearlayout_menu_one.setVisibility(View.VISIBLE);}
if(restaurant.getMenus().size()>=3){
        Picasso.with(context).load("http://example.com/uploads/menus/" + restaurant.getMenus().get(2).getMenuImage()).into(img_menu_two);
        linearlayout_menu_two.setVisibility(View.VISIBLE);}
if(restaurant.getMenus().size()>=4){
        Picasso.with(context).load("http://example.com/uploads/menus/" + restaurant.getMenus().get(3).getMenuImage()).into(img_menu_three);
        linearlayout_menu_three.setVisibility(View.VISIBLE);}

    }