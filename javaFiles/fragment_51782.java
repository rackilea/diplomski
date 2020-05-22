Bundle bundle = new Bundle();
bundle.putString("key","abc"); // Put anything what you want

Fragment_2 fragment2 = new Fragment_2();
fragment2.setArguments(bundle);

getFragmentManager()
      .beginTransaction()
      .replace(R.id.content, fragment2)
      .commit();