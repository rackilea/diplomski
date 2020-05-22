boolean vonModeratorGesendet = false;
for (int i2 = 0; i2 < moderatoren.length; i2++) {
    if (sender.equals(moderatoren[i2])) {
        vonModeratorGesendet = true;
        // you could also send "!highfive" from here
        break;
    }
}
if (vonModeratorGesendet) {
    sendMessage (channel, "!highfive");
} else {
    sendMessage(channel, "Nur eingetragene Moderatoren haben Zugriff auf diesen Befehl. Sry <3");
}