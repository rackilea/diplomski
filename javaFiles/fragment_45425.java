int arabic_unicode = 1632;
          int num = 786;
            String str_en = num+"";
            StringBuilder builder_ar = new StringBuilder();

            for (int i = 0; i < str_en.length(); ++i) {
                builder_ar.append((char) ((int) str_en.charAt(i) - 48 + arabic_unicode));
            }

System.out.println("Arabic : " + builder_ar.toString());