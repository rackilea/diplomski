String[] name_and_path_of_files = {
        "C:\\Users\\Asus\\Documents\\NetBeansProjects\\NesneProjesi\\src\\1574683.txt",
        "C:\\Users\\Asus\\Documents\\NetBeansProjects\\NesneProjesi\\src\\\\2454438.txt",
        "C:\\Users\\Asus\\Documents\\NetBeansProjects\\NesneProjesi\\src\\\\9146578.txt"
    };
        Scanner inputFileReader = null;
        Liman liman = new Liman();
    try {
        for (String fileInfo : name_and_path_of_files) {

            inputFileReader = new Scanner(new File(fileInfo));

            int line_index = 0;
            Gemi yeniGemi = null; //---declare your arraylist-containing object here.
            while (inputFileReader.hasNext()) {
                    //String separated_numbers[] = inputFileReader.nextLine().split(" ");
                    //inputFileReader.useDelimiter("\\\\d+");
                    int IMO = inputFileReader.nextInt();
                    String isim = inputFileReader.next();
                    if(inputFileReader.hasNextInt()){
                        int Max_Konteyner_sayisi = inputFileReader.nextInt();
                        int Buyuk_Konteyner_sayisi = inputFileReader.nextInt();
                        int Sogutuculu_Konteyner_sayisi = inputFileReader.nextInt();
                        int Toksik_Taşıma_siniri = inputFileReader.nextInt();
                        int Patlayıcı_Taşıma_siniri = inputFileReader.nextInt();
                        yeniGemi = new Gemi(IMO, isim, Max_Konteyner_sayisi, Buyuk_Konteyner_sayisi,
                                Sogutuculu_Konteyner_sayisi,Toksik_Taşıma_siniri, Patlayıcı_Taşıma_siniri)
                        liman.gemiEkle(yeniGemi); //gemiEkle adds ships into limans arraylist 'Gemiler'.
                        System.out.println(liman.Gemiler);
                    }
                    else{
                        //int Seri_Numarasi = inputFileReader.nextInt();//---why repeat when you have retrived this line's leading values?
                        //String Konteyner_Ozelligi = inputFileReader.next();
                        String Icerik_Ozelligi = inputFileReader.next();
                        Konteyner yeniKonteyner = new Konteyner(IMO,isim,Icerik_Ozelligi);
                        yeniGemi.konteynerEkle(yeniKonteyner);
                        System.out.println(yeniGemi.Konteynerler.toString());
                        }
            }    
        }
        //System.out.println(liman.Gemiler);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
            inputFileReader.close();
    }