private void changeIcon(){
        MenuItem mi = mMenu.findItem(R.id.actionMenu);

        try {
            if(this.theSwitcher){
                // What code need this function?
                // I just need to change icon1 to icon2
                mi.setIcon(R.drawable.icon2);
                this.theSwitcher = false;
            } else {
                // What code need this function?
                // I just need to change icon2 to icon1
                mi.setIcon(R.drawable.icon1);
                this.quince = true;
            }

        } catch (Exception e) {
            Log.e("MyBad", "Error: " + e);
        }

    }