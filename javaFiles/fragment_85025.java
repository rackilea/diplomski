@Override
    protected Integer doInBackground() {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                "D:\\ffmpeg.exe", "-i", "\"D:\\video\\input.mp4\"", "\"output.mp4\""));
        …
    }