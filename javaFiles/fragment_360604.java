try (Stream<Path> paths = Files.walk(Paths.get("/your/path/"), 1)) {
            return paths
                    .filter(Files::isRegularFile)
                    .anyMatch(f -> {
                        final String fileName = f.getFileName().toString();
                        return fileName.startsWith("ecap_data_") && fileName.endsWith(".csv");
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }