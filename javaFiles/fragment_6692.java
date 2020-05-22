String hwndString = "native@0xa021c";
HWND temp = new HWND();
temp.setPointer(new Pointer(Long.decode(hwndString.substring(7))));
if(User32.INSTANCE.IsWindow(temp)){
     //This is a valid window
}
else{
     // Invalid Window
}