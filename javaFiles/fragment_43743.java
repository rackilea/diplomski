LinkedHashMap<String, Cell> hash = new LinkedHashMap<>();

        for(int counter = 1; counter <4; counter++){


            Cell[] contentTable = new Cell[]{
                    new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(String.valueOf(counter))).setBackgroundColor(ColorConstants.LIGHT_GRAY),
                    new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("key " + counter)),
                    new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("value " + counter))

            };

            for (Cell tabCell : contentTable){  
                hash.put("key",tabCell);
                if(counter % 2 == 0){                   
                    tabCell.setBackgroundColor(DeviceGray.WHITE);
                }else {                 
                    tabCell.setBackgroundColor(new DeviceGray(0.75f));  
                }

                content.addFooterCell(hash.get("key"));

            }

        }