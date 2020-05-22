public List<String> read(MultipartFile file) throws IOException {
        InputStreamReader in = new InputStreamReader(file.getInputStream());
        try (BufferedReader reader = new BufferedReader(in)) {
            return reader.lines().collect(Collectors.toList());
        }
    }