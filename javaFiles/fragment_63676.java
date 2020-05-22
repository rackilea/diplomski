String email = "someone@somewhere.any";
    StringBuilder buffer = new StringBuilder(email.length() * 6);
    for (char c : email.toCharArray()) {
        buffer.append("&#").append((int) c).append(';');
    }
    System.out.println(buffer);