switch(v.getId())

    {
        case R.id.moveButton: 


            boolean check = ((ToggleButton) v).isChecked();
            if (check) {
                ImageView img_animationOne = (ImageView) findViewById(R.id.player);

                TranslateAnimation animation = new TranslateAnimation(.0f, 200.0f,
                        0.0f, 0.0f);
                animation.setDuration(1000);
                animation.setRepeatCount(1);
                animation.setRepeatMode(2);
                animation.setFillAfter(true);
                img_animationOne.startAnimation(animation);

            } else {
                ImageView img_animationOne = (ImageView) findViewById(R.id.player);

                TranslateAnimation animation = new TranslateAnimation(200.0f, 0.0f,
                        0.0f, 0.0f);
                animation.setDuration(1000);
                animation.setRepeatCount(1);
                animation.setRepeatMode(2);
                animation.setFillAfter(true);
                img_animationOne.startAnimation(animation);

            }
    break;

        }