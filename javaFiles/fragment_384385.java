rolebutton.setOnClickListener(new View.OnClickListener() {
    boolean isPressed = false;

    public void onClick(View v) {

   rolebutton.setBackgroundResource(isPressed ? R.drawable.role_button : R.drawable.role_button_pressed));
   isPressed = !isPressed;
}
}