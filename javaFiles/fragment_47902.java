synchronized (out) {
    out.print(String.format("uploading '%s': %s, %d%s...", fileName, p.getContentType(), sizeInKb, "KB"));
    if (success){
        out.println("OK<br>");
        uploadedAnything = true;
    }
    else out.println("FAILED<br>");
}