a = 0;
        CompoundButton.OnCheckedChangeListener multiListener = new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                switch (v.getId()){
                    case R.id.checkbox1:
                        if (isChecked) {
                        a++;
                    }
                    else {
                        a--;
                    }
                        break;
                    case R.id.checkbox2:
                        if (isChecked) {
                            a++;
                        }
                        else {
                            a--;
                        }
                        break;
                    case R.id.checkbox3:
                        if (isChecked) {
                            a++;
                        }
                        else {
                            a--;
                        }
                        break;
                    case R.id.checkbox4:
                        if (isChecked) {
                            a++;
                        }
                        else {
                            a--;
                        }
                        break;
                }
                if (a == 4){
                    CompoundButtonCompat.setButtonTintList(checkbox1, ColorStateList.valueOf(context.getResources().getColor(R.color.red)));
                    CompoundButtonCompat.setButtonTintList(checkbox2, ColorStateList.valueOf(context.getResources().getColor(R.color.red)));
                    CompoundButtonCompat.setButtonTintList(checkbox3, ColorStateList.valueOf(context.getResources().getColor(R.color.red)));
                    CompoundButtonCompat.setButtonTintList(checkbox4, ColorStateList.valueOf(context.getResources().getColor(R.color.red)));
                }
                if (a == 3){
                    CompoundButtonCompat.setButtonTintList(checkbox1, ColorStateList.valueOf(context.getResources().getColor(R.color.orange)));
                    CompoundButtonCompat.setButtonTintList(checkbox2, ColorStateList.valueOf(context.getResources().getColor(R.color.orange)));
                    CompoundButtonCompat.setButtonTintList(checkbox3, ColorStateList.valueOf(context.getResources().getColor(R.color.orange)));
                    CompoundButtonCompat.setButtonTintList(checkbox4, ColorStateList.valueOf(context.getResources().getColor(R.color.orange)));
                }
                if (a == 2){
                    CompoundButtonCompat.setButtonTintList(checkbox1, ColorStateList.valueOf(context.getResources().getColor(R.color.yellow)));
                    CompoundButtonCompat.setButtonTintList(checkbox2, ColorStateList.valueOf(context.getResources().getColor(R.color.yellow)));
                    CompoundButtonCompat.setButtonTintList(checkbox3, ColorStateList.valueOf(context.getResources().getColor(R.color.yellow)));
                    CompoundButtonCompat.setButtonTintList(checkbox4, ColorStateList.valueOf(context.getResources().getColor(R.color.yellow)));
                }
                if (a == 1){
                    CompoundButtonCompat.setButtonTintList(checkbox1, ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
                    CompoundButtonCompat.setButtonTintList(checkbox2, ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
                    CompoundButtonCompat.setButtonTintList(checkbox3, ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
                    CompoundButtonCompat.setButtonTintList(checkbox4, ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
                }
            }
        };

 checkbox1.setOnCheckedChangeListener(multiListener);
                checkbox2.setOnCheckedChangeListener(multiListener);
                checkbox3.setOnCheckedChangeListener(multiListener);
                checkbox4.setOnCheckedChangeListener(multiListener);