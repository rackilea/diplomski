final String input = "Tĥïŝ ĩš â fůňķŷ Šťŕĭńġ";
System.out.println(
    Normalizer
        .normalize(input, Normalizer.Form.NFD)
        .replaceAll("[^\\p{ASCII}]", "")
);