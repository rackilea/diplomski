if() { // some condition when you want imageButton1 to be visibile and others invisible
    imageButton1.setVisibility(View.VISIBLE);     
    imageButton2.setVisibility(View.INVISIBLE);
    imageButton3.setVisibility(View.INVISIBLE);
} else if() { // some other condition when you want imageButton2 to be visibile and others invisible
    imageButton1.setVisibility(View.INVISIBLE);
    imageButton2.setVisibility(View.VISIBLE);
    imageButton3.setVisibility(View.INVISIBLE);
} else { // when you want imageButton3 to be visibile and others invisible
    imageButton1.setVisibility(View.INVISIBLE);
    imageButton2.setVisibility(View.INVISIBLE);
    imageButton3.setVisibility(View.VISIBLE);
}