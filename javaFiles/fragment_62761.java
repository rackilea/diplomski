static int index(String lookInStr, char lookUpChr) {
    return lookInStr.indexOf(new String(new char[] { lookUpChr, lookUpChr, lookUpChr }));
}

public static void main(String[] args) {
    String linha = "####,@@@@@@@@,$$$$,%%%%,@%@@@,!!!!", validos = "$#%!@";
    for (int i = 0; i < validos.length(); i++) {
        char currentSearchChar = validos.charAt(i);
        do {
            int index = index(linha, currentSearchChar);
            if (index >= 0) {
                int count = -1;
                do {
                    count++;
                } while (linha.charAt(count + index) == currentSearchChar && count + index < linha.length() - 1);
                String replacementSeq = "";
                for (int j = 0; j < count; j++) {
                    replacementSeq += "-";
                }
                linha = linha.replaceAll("\\" + validos.charAt(i) + "{" + count + ",}", replacementSeq);
            }
        } while (index(linha, currentSearchChar) >= 0);
    }
    System.out.println(linha);
}