String tempHash = "123456789ABCDEF123456789ABCDEF12";

String binary = tempHash.chars()              // Get stream of chars
    .map(c -> Character.digit(c, 16))         // Convert to hex digit
    .mapToObj(Integer::toBinaryString)        // Convert to binary
    .map(s -> "0".repeat(8 - s.length()) + s) // Pad left with zeros
    .collect(Collectors.joining(" "));        // Collect to String

System.out.println(binary);