int[] ints = new int[] { 0x52, 0xe4, 0x18, 0xcb };
FileOutputStream os = new FileOutputStream(new File("/tmp/x"));
for (int i : ints) {
    os.write(i);
}
os.close();