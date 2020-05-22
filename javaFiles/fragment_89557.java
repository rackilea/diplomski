try {
 return new FileImageOutputStream((File)output);
} catch (Exception e) {
 e.printStackTrace();
 return null;
}