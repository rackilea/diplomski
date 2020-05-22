Face face = new Face(vertices.get(Integer.parseInt(tokens[1]) - 1), vertices.get(Integer.parseInt(tokens[2]) - 1), vertices.get(Integer.parseInt(tokens[1]) - 1));
    if (normals.size() > 0) {
        face.setAn(normals.get(Integer.parseInt(tokens[1]) - 1));
        face.setBn(normals.get(Integer.parseInt(tokens[2]) - 1));
        face.setCn(normals.get(Integer.parseInt(tokens[3]) - 1));
    }