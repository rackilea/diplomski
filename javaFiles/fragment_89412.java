Bitmap bmp = null;
        String filename = String.valueof(getId())+".png";
        try {
            FileInputStream is = this.openFileInput(filename);
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(bmp!=null)
        {
            ConstraintLayout cl =findViewById(R.id.shopbk); //it can be your any view
            BitmapDrawable ob = new BitmapDrawable(getResources(), bmp);
            cl.setBackground(ob); /* you should use glide here to show bitmap drawable as your preview will be very small as compared to screenshot actual size*/
        }