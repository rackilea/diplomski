for (XWPFParagraph paragraph : docx.getParagraphs()) {
                int pos = 0;
                for (XWPFRun run : paragraph.getRuns()) {
                    System.out.println("Current run IsBold : " + run.isBold());
                    System.out.println("Current run IsItalic : " + run.isItalic());
                    for (char c : run.text().toCharArray()) {

                        System.out.print(c);
                        pos++;
                    }
                    System.out.println();
                }
            }