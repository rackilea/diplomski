public void setFocusedButton() {
        for(int i=0; i<mLeftView.btns.length;i++){
            if(mLeftView.btns[i].isFocused() || mRightView.btns[i].isFocused()) {
                mLeftView.btns[i].setBackgroundResource(R.drawable.button_pressed);
                mRightView.btns[i].setBackgroundResource(R.drawable.button_pressed);
            }else {
                mLeftView.btns[i].setBackgroundResource(R.drawable.button);
                mRightView.btns[i].setBackgroundResource(R.drawable.button);
            }
        }

    }