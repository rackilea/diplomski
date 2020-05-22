//The correct way to load and Image:


private String getEmojiImagePath(String hexStr)
{
    String filePath = "resources/com/uz/emojione/fx/png_40/" + hexStr + ".png";
    File file = new File(filePath);

    return file.toURI().toString();
}