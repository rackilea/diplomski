SearchFragment searchFragment = new SearchFragment(MainActivity.this);
                searchFragment.setArguments(extra);
                fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.myFragmwent_layout,searchFragment,"first");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();