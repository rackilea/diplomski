try (InputStream tikaStream = TikaInputStream.get(new URL(externalFileURL))) {
    TikaConfig tikaConfig = new TikaConfig();
    MediaType mediaType = tikaConfig.getDetector().detect(tikaStream, new Metadata());

    httpServletResponse.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "DownloadMe." + mediaType.getSubtype()));
    httpServletResponse.setContentType(mediaType.getBaseType().toString());
    FileCopyUtils.copy(tikaStream, httpServletResponse.getOutputStream());
    httpServletResponse.flushBuffer();
}