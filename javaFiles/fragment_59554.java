try (Stream<String> stream = Files.lines(Paths.get(fileName))) 
    {
        stream.forEach(s -> {adder+=Double.parseDouble(s); counter++;});

    } catch (IOException e) {
        e.printStackTrace();
    }