@PostMapping("/api/upload/multi/model")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute FormWrapper model) {
        try {
            saveUploadedFile(model.getImage());
            formRepo.save(mode.getTitle(),model.getDescription()); //Save as you want as per requirement 
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
    }