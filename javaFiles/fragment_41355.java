LabelField  Number = new LabelField("+91-79-30345487400a5675675676", FIELD_VCENTER|Field.FOCUSABLE) {
        protected void paint(Graphics g) {
            g.setColor(0x324F85);

            // g.fillRoundRect(0, 0, 50, 5, 7, 7);
            super.paint(g);
        }
        protected boolean navigationClick(int status, int time) {
           Dialog.alert("clicked");
            return super.navigationClick(status, time);
        }


        };
        add(Number);