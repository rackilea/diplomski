Map<String, Set<String>> map = arg0.getSubstylearea()
    int index = new Random().nextInt(map.size());
    int i = 0;
    for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
        if (i++ < index) {
            continue;
        }
        String key = entry.getKey();
        Set<String> temp = arg0.getSubstylearea().get(key);

        if (key.equals("Eyes")) {
            flatont.setStylearea1(key);
            System.out.println("This Doesnt Print");
            for (String s : temp) {

                flatont.setStylesubarea1(s);

            }
        } else if (key.equals("Face")) {

            flatont.setStylearea1(key);

            for (String s : temp) {

                flatont.setStylesubarea1(s);
            }
        } else if (key.equals("Lips")) {

            flatont.setStylearea1(key);

            for (String s : temp) {

                flatont.setStylesubarea1(s);
            }
        } else {
            // Do something else
        }
        break;
    }