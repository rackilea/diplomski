Bundle arguments = new Bundle();
                    arguments.putInt(FragmentTwo.ARG_ITEM_ID,R.drawable_pic);
                    FragmentTwo fragment = new FragmentTwo();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();