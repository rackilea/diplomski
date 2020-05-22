public static void loadOpenCVLib(String path) throws Exception {
    File lib_dir = new File(path);
    System.setProperty("java.library.path", lib_dir.getAbsolutePath());
    Field sys_paths = ClassLoader.class.getDeclaredField("sys_paths");
    sys_paths.setAccessible(true);
    sys_paths.set(null, null);
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    // it is for the ffmpeg name
    String[] list = lib_dir.list();
    assert list != null;
    String ffmpeg_dll_file_name = null;
    for (String s : list) {
        if (s.contains("ffmpeg")) {
            ffmpeg_dll_file_name = s.substring(0, s.indexOf("."));
        }
    }
    System.loadLibrary(ffmpeg_dll_file_name);
}