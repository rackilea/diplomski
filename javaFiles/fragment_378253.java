for(int i=0;i<in.length();i++) {// i=0
            for (int j = 0; j < vakken.length; j++) {
                for (int k = 0; k < vakken[j].length; k++) {

                    if (in.charAt(i) == '.') {//looking for charAt(0)
                        this.vakken[j][k] = new Vak();
                i++;//if this condition satisfies i=1
                    }
                    if (in.charAt(i) == 'K') {//if last if condition satisfies looking for charAt(1)
                        this.vakken[j][k] = new Vak(false, false, new Kist());
                i++;//if this condition satisfies i=2
                    }
                    if (in.charAt(i) == 'D') {//if last if condition satisfies looking for charAt(2)
                        this.vakken[j][k] = new Vak(true, false);
                i++;//if this condition satisfies i=3
                    }
                    if (in.charAt(i) == 'M') {//if last if condition satisfies looking for charAt(3)
                        this.vakken[j][k] = new Vak(false, false, new Man());

                                 muur++;
                i++;//if this condition satisfies i=4
                    }
                     if (in.charAt(i) == '#') {//if last if condition satisfies looking for charAt(4)
                        this.vakken[j][k] = new Vak(false, true);
            i++;//if this condition satisfies i=5
                    }
                }
            }