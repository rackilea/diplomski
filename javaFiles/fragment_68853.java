if (rflag== 1) {
                mQwertyKeyboard.getKeys().get(29).label = "NewTag";
                rflag = 0;
            } else {
                rflag = 1;
                mQwertyKeyboard.getKeys().get(29).label = "OldTag";                 

            }