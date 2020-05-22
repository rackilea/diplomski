while (i < 13){
        Random r = new Random();
        int Character = r.nextInt(GenPass.length);
        System.out.println(GenPass[Character]);
        GeneratedPass = GeneratedPass + GenPass[Character];
        i++;
    }
    return  GeneratedPass;
}