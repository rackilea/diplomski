String string = "et le mot de passe suivants :\n\n" +
                "nom d'utilisateur : Information\n\n" +
                "mot de passe : wJJNfeRPLC\n\n" +
                "Vous pouvez aussi vous connecter en cliquant sur ce lien ou le copier-coller dans votre navigateur";

Pattern pattern = Pattern.compile("(?<=mot de passe : )(\\w+)$", Pattern.MULTILINE);
Matcher matcher = pattern.matcher(string);
if (matcher.find()) {
  String password = matcher.group();
  System.out.println(password);
}