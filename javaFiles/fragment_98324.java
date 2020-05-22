List<String> moderatorenListe = Arrays.asList(moderatoren);
if (moderatorenListe.contains(sender)) {
    sendMessage (channel, "!highfive");
} else {
    sendMessage(channel, "Nur eingetragene Moderatoren haben Zugriff auf diesen Befehl. Sry <3");
}