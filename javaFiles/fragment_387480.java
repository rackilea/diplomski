InputStream inputStream = new BufferedInputStream(new URL("http://localhost:6582?BRIDGE&%2FGOPR0175.MP4&GOPR0175.MP4&80898399").openConnection().getInputStream());
GoProTagsBox tags = GoProUtil.getHilights(inputStream);

stringBuilder.append("Count: "+tags.getCount());
if(tags.getHiLights() != null){
    for (long l : tags.getHiLights()) {
        stringBuilder.append("\nHiLight: "+l);
    }
}