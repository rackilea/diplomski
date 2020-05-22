for (Animals p : animalList) { // Loop through the passengers to store
            // every passenger as the line of strings to add them to the file.
            output.append(p.getID()).append(",").append(p.getAge()).append(",").append(p.getBreed()).append(",")
                    .append(p.getMother()).append(",").append(p.getFather()).append(",").append(p.getMedical()).append(",")
                    .append(p.getIdenti()).append(",").append(p.getPrice()).append(",").append(p.getOwner()).append(",").append("\r\n"); //add another append between getOwner and \r\n
        }