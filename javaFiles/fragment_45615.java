public static void main(String[] args) throws ParseException {
    List<String> strings = Arrays.asList(
            "https://example.cdn.com/mp4/7/9/5/file_795f32460d111df334849ee8336e56ca.mp4?e=1535545105&h=4772d27a70cd9b1c665b712f62592c47&download=1",
            "http://example.cdn.comr/post/93/3/Jozve-Kamele-arbi.abp.zip",
            "http://cdl.example.com/?b=dl-software&f=Windows.8.1.Enterprise.x86.Aug.2018_n.part1.rar",
            "https://www.google.com/url?sa=t&source=web&rct=j&url=http://www.pdf995.com/samples/pdf.pdf&ved=2ahUKEwjV096X-ZHdAhVQzlkKHTpUBV4QFjAAegQIARAB&usg=AOvVaw3HFvAQ7GNf5QjsUo05ot-j",
            "https://www.google.com/url?sa=t&source=web&rct=j&url=http://www.pdf995.com/samples/pdf.PDF&ved=2ahUKEwjV096X-ZHdAhVQzlkKHTpUBV4QFjAAegQIARAB&usg=AOvVaw3HFvAQ7GNf5QjsUo05ot-j");
    strings.stream().map(s -> extractFileFrom(s)).collect(Collectors.toList())
        .forEach(System.out::println);
}