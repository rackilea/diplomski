for (String userToken : message.split(" ")) {
        if (legalEnglishWords.contains(userToken)) {
            System.out.println(userToken + " is an English word ");
        }
    }
  }
}