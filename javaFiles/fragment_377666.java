public static void eSpremnicaHandel(String csvFile) {

        String line = "";
        String cvsSplitBy = "|";


        Oddaja oddaja = new Oddaja();
        ArrayOfRegPosiljka regp = new ArrayOfRegPosiljka();

        oddaja.setWPID("CertSubject");
        oddaja.setKOMID(21553);
        oddaja.setSTODD(0);
        oddaja.setPOGID(2427);
        oddaja.setPODID(0);
        oddaja.setPOSID("7733");
        oddaja.setRegistriranePosiljke(regp);

        ObjectFactory fc = new ObjectFactory();
        Oddaja odd = fc.createOddaja();
        odd.setWPID(oddaja.getWPID());
        odd.setSTODD(oddaja.getSTODD());
        odd.setKOMID(oddaja.getKOMID());
        odd.setPOGID(oddaja.getPOGID());
        odd.setPODID(oddaja.getPODID());
        odd.setPOSID(oddaja.getPOSID());

        odd.setRegistriranePosiljke(oddaja.getRegistriranePosiljke());

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                RegistriranaPosiljka regpos = new RegistriranaPosiljka();

                // use delimiter as separator
                String[] podatki = line.split(Pattern.quote(cvsSplitBy));

                regpos.setZAPST(Integer.parseInt(podatki[0]));
                regpos.setREG(podatki[1]);

                Naslovnik nasl = new Naslovnik();
                nasl.setNAZ(podatki[2]);
                nasl.setPOSTST(podatki[3]);

                Posiljka pos = new Posiljka();
                pos.setMAS(new BigDecimal(podatki[4]));

                Storitev sto = new Storitev();
                sto.setNAZ(podatki[7]);
                regpos.setNAS(nasl);

                regp.getREGPOS().add(regpos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            JAXBContext jc = JAXBContext.newInstance("generated");
            JAXBElement<Oddaja> element = fc.createOddaja(oddaja);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(element, System.out);
            ms.marshal(element, new File("src/eSpremnicaXML/test2.xml"));
        } catch(Exception e) {
            e.printStackTrace();
        }

    }