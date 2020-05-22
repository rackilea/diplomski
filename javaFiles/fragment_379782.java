viewHolder.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == false) {
                    hideKeyboard(view.getContext(), view);
                }
            }
        });