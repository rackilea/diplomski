new SimpleDateFormat(format).parse(
    date.replace("st of", "")
        .replace("nd of", "")
        .replace("rd of", "")
        .replace("th of", "")
);