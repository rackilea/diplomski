public void onSectionAttached(int number) {

        if (menuItems == null){

          menuItems = new ArrayList<String>();
          menuItems.add("Test");
          menuItems.add("Test2");
          menuItems.add("TestThree");
        }

        switch (number) {
            case 1:
                mTitle = menuItems.get(0);
                break;
            case 2:
                mTitle = menuItems.get(1);
                break;
            case 3:
                mTitle = menuItems.get(2);
                break;
        }

    }