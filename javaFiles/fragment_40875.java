for (int i = 0; i < length; i++) {
            String line = reader.readLine();
            if(line != null) {
                String[] elements = line.split("\\|");
                name[i] = elements[0];
                cost[i] = elements[1];
                color[i] = elements[2];
                type[i] = elements3];
                cTypes[i] = elements[4];
                tags[i] = elements[5];
                text[i] = elements[6].replaceAll("•","\n");
                power[i] = Integer.parseInt(elements[7]);
                toughness[i] = Integer.parseInt(elements[8]);
                creatures[i] = new Creature(name[i], cost[i], color[i], type[i], cTypes[i], tags[i], text[i], power[i], toughness[i]);
                }
            }