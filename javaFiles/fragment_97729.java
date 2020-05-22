pippo;pluto;paperino
casa;terra;cortile
primo;secondo;terzo

Comparator<String> comparator = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.split(";")[2].compareTo(o2.split(";")[2]);

                }
            };

            lines.sort(comparator);