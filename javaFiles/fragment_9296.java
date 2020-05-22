// Read from same package
InputStream inputStream = getClass().getResourceAsStream("abc.wav");

// Read from music folder parallel to src in your project
File file = new File("music/abc.wav");

// Read from src/music folder
URL url = getClass().getResource("/music/abc.wav");

// Read from src/music folder
InputStream inputStream = getClass().getResourceAsStream("/music/abc.wav");