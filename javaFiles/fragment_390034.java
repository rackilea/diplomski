for (int i = 0; i < parentLinearLayout.getChildCount(); i++) {
            View view = parentLinearLayout.getChildAt(i);
            if (view.getTag().equals(myTagCount)) {
                EditText editText = (EditText) view.findViewById(R.id.edt1);

                String myText = editText.getText().toString();
                break;
            }

        }