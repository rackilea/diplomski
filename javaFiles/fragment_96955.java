if(line != null) {
    putdata = line.replace("{CUSTOMER_NAME}", name)
            .replace("{CURRENT_LIMIT}", limit)
            .replace("{NEW_LIMIT}", nlimit);
    bw.write(putdata);
    // append a line separator to current line
    bw.newLine();
}