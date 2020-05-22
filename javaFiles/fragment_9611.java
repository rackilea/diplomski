while ((sCurrentLine = br.readLine()) != null) {
    if (!sCurrentLine.isEmpty()) {
        int num = Integer.parseInt(sCurrentLine);
        System.out.println(num);
    }
}