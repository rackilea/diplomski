txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegisterFragment registerFragment = new RegisterFragment();
                if(registerFragment !=null) {
                registerFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                registerFragment.show(getFragmentManager(), "dialog");

                }

            }
        });