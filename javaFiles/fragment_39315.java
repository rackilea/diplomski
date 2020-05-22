while ((s=br.readLine())!=null) {
    if(s.contains(keyword)) {
        //System.out.println(s);
        String nextLine = br.readLine();
        System.out.println(nextLine);
    }
}