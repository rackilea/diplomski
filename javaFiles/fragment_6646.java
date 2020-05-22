else if (spaceSplit[0].equals("edit")) {
            if(spaceSplit.length > 1) {
                String name = spaceSplit[1];
                boolean endOfFile = false;
                String content = "";

                while (!(content.contains("<<EOF>>"))) {
                    String userInput = s.nextLine();
                    content += userInput + " ";
                }

                String end = "<<EOF>>";

                content = content.replace(end, "");

                int size = tree.getTexts().size();

                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        if (tree.getTexts().get(i).getName().equals(name)) {
                            tree.getTexts().get(i).setContent(content);
                        } 
                    }
                    tree.edit(name, content);
                } else {
                    tree.edit(name, content);
                }
            }

        }