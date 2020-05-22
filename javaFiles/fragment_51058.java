try {
    readFile(path);
} catch (IOException e) {
    // handle first exception here
}

// more code
try {
    convert(file)
} catch (IOException e) {
    // handle second exception here
}