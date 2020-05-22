public String readFile(String file, char mode) {
    if (mode != 'Q' && mode != 'A') return "" ; 

    return Files.lines(Paths.get(file))
        .filter(line -> line.charAt(0) == mode)
        .collect(Collectors.joining("\n"));
}