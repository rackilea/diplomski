switch(Rechenoperation) {
            case 1: //+
                value2 = Integer.valueOf(jLabel1.getText());
                Ergebnis = value1 + value2;
                setlabeltext(Ergebnis);
                break;
            case 2: //-
                value2 = Integer.valueOf(jLabel1.getText());
                Ergebnis = value1 - value2;
                setlabeltext(Ergebnis);
                break;
            case 3: //x
                value2 = Integer.valueOf(jLabel1.getText());
                Ergebnis = value1 * value2;
                setlabeltext(Ergebnis);
                break;
            case 4: //:
                value2 = Integer.valueOf(jLabel1.getText());
                if(value2 != 0){ //Add a safeguard if value2 is '0'
                    Ergebnis = value1 / value2;
                    setlabeltext(Ergebnis);
                } else {
                    setlabeltext("NaN");
                }
                break;
        }