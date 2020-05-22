int index = 0;
                int paragraphCount = 1; // starting on first paragraph
                String[] parts = totalPassage.split("\n");
                for(String part : parts){
                   if(part.length() == 0) {    
                       paragraphCount++;
                   }
                   if(paragraphCount==2){
                       g.setColor(Color.RED);
                   }else{
                       g.setColor(Color.BLACK);
                   }
                    g.drawString(part, (float) bounds.getX(), (float) -bounds.getY() + 20 * index++);
                }