for (Path entry : stream) {
            System.out.println(entry.getFileName() + " | " + entry.toFile().isDirectory());
            if (!entry.toFile().isDirectory()) {
                list.add(entry.getFileName().toString());
            }
        }