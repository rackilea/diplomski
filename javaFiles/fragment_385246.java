int currentImage = 0;
String[] strArr = new String[array_image.size()];
strArr = array_image.toArray(stockArr);

       @Override
    public void onClick(View v) {

        if (btnNext == v) {

           currentImage++;
                currentImage = currentImage % strArr .length;

                iv.setImageResource(strArr .length[currentImage]);

        } else if (btnBack == v) {
            currentImage--;
                currentImage = (currentImage + strArr .length) % strArr .length;

                iv.setImageResource(strArr[currentImage]);
        }

    }