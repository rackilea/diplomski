byte[] bytes = new byte[len];
s = _input.read(bytes);
while(s==-1){
    Thread.sleep(1);
    s = _input.read(bytes);
}

return new String(bytes);