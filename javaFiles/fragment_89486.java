HorizontalFieldManager VFM = new HorizontalFieldManager(){
        public void paint(Graphics g) {
        g.setBackgroundColor(Color.WHITE);
        g.clear();
        super.paint(g);
        }
        };

        HorizontalFieldManager LogoHFM = new HorizontalFieldManager(FIELD_LEFT);
        Bitmap logom1;
        logom1 = Bitmap.getBitmapResource("logo48X48.png");
        BitmapField imgField = new BitmapField(logom1);
        LogoHFM.add(imgField);


        LabelField RegistrationLbl = new LabelField("Registration",FIELD_HCENTER);
        FontFamily fontFamily[] = FontFamily.getFontFamilies();
        Font font = fontFamily[1].getFont(FontFamily.CBTF_FONT, 20);
        font = fontFamily[1].getFont(Font.BOLD, 25);
        RegistrationLbl.setFont(font);
        RegistrationLbl.setMargin(0,0,0,(Display.getWidth()-logom1.getWidth())/4);


        VFM.add(LogoHFM);
        VFM.add(RegistrationLbl);
        add(VFM);