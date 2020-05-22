FragmentManager fragmentManager = getFragmentManager();
       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       Fragment fragment = new ViewControllerFragment();

       ObjectA obj = new ObjectA();
       Bundle bundle = new Bundle();
       bundle.putStringArrayList("Titles", obj.getTitles());
       bundle.putStringArrayList("Descriptions", obj.getDescriptions());
       bundle.putStringArrayList("Images", obj.getImages());
       fragment.setArguments(bundle);

       fragmentTransaction.commit();