@PostMapping(value = "/upload", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, @RequestParam("id") Integer merchantId) throws Exception {
        try {
            File directory = new File(properties.getFileUploadDir(), merchantId.toString());
            directory.mkdirs();
            Path writeTargetPath = Files.write(
                    Paths.get(directory.getAbsolutePath(), file.getOriginalFilename()).toAbsolutePath(),
                    file.getBytes(), StandardOpenOption.CREATE_NEW);
            Path fileToMovePath = Paths.get(properties.getFileUploadDir(), merchantId.toString(), "merchant_logo.png");
            Path movedPath = Files.move(writeTargetPath, fileToMovePath, StandardCopyOption.REPLACE_EXISTING);
            log.info("movedPath: {}", movedPath.toAbsolutePath());

            redirectAttributes.addFlashAttribute("message",
                    "Successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            log.error("IOException: {}", e);
            return ResponseEntity.ok("Upload failed'" + file.getOriginalFilename() + "'");
        }
        return ResponseEntity.ok("Successfully uploaded'" + file.getOriginalFilename() + "'");
    }