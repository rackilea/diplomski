String dosya = "Test cumle 1. CUmle 2.\nCumle 3 here. Next sentences. Last sentences.";

        String[] dizi_paragraf = dosya.split("\n");
        for (int i = 0; i < dizi_paragraf.length; i++) {
            String[] dizi_cumle = dizi_paragraf[i].split("\\.");
            String[][] dizi_total = new String[dizi_paragraf.length][dizi_cumle.length];
            int[][] dizi = new int[dizi_paragraf.length][dizi_cumle.length];

            List<Integer> jj = new ArrayList<>();
            for (int j = 0; j < dizi_cumle.length; j++) {
                jj.add(j);
            }
            Collections.shuffle(jj);
            for (int j:jj) {
                dizi_total[i][j] = dizi_cumle[j];
                dizi[i][j] = j;
                System.out.println("dizi[i][j] "+i+"-"+j);
            }
        }