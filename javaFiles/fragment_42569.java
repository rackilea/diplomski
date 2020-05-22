FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    if (!back)
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
    else
        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);

    switch (fragment)
    {
        case F1:
            ft.replace(R.id.fl_root, new F1(), String.valueOf(F1));
            break;
        //...
    }