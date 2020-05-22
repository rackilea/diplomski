button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          String message = editText.getText().toString();
          messageReadListener.onMessageRead(message);
    }
  });