for(int i=0;i<in.length();i++) {// i=99
                for (int j = 0; j < vakken.length; j++) {
                    for (int k = 0; k < vakken[j].length; k++) {

                        if (in.charAt(i) == '.') {//looking for charAt(99)
                            this.vakken[j][k] = new Vak();
                    i++;//if this condition satisfies i=100
                        }
                        if (in.charAt(i) == 'K') {
                        //if last if condition satisfies 
                        //looking for charAt(100) 
                        //now charAt(100) dose not exists 
                        //and an error occurs that String out of range
                            this.vakken[j][k] = new Vak(false, false, new Kist());
                    i++;
                        }
                        if (in.charAt(i) == 'D') {
                            this.vakken[j][k] = new Vak(true, false);
                    i++;
                        }
                        if (in.charAt(i) == 'M') {
                            this.vakken[j][k] = new Vak(false, false, new Man());

                                     muur++;
                    i++;
                        }
                         if (in.charAt(i) == '#') {
                            this.vakken[j][k] = new Vak(false, true);
                i++;
                        }
                    }
                }