while ((line = bufferedReader.readLine()) != null) {
    if (line.contains("open")) {
        killGps();
        break;
    }
}