public static void checkSelected() {
    for (boolean radioChecked : checked) {
        if(true == radioChecked){
            buttonCheckAnswer.setVisibility(View.VISIBLE);
            break;
        }
    }
}