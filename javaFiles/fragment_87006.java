public static class MyClickListener implements OnClickListener {
Editor editor;
public MyClickListener(Editor e) {
   this editor= e;
}
public void onClick(View v) {
  editor.saveEditor(v);
}
}

buttonSave.setOnClickListener(new MyClickListener());