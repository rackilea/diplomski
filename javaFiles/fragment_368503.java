Button GoToContact=(Button)findViewById(R.id.btnGoToContact);
        GoToContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpFragment HelpFragment = new HelpFragment();
                FragmentManager manager1 = getSupportFragmentManager();
                manager1.beginTransaction().replace(R.id.relativelayout_for_fragment,
                        HelpFragment,
                        HelpFragment.getTag()
                ).commit();
            }
        });