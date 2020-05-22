String a = "13:12:09.110 [botPool0-bot0] INFO org.pircbotx.InputParser - :jdbener!jdbener@jdbener.tmi.twitch.tv PRIVMSG #irish_00 :yay";

 String[] b = a.split(":");

 String c =   b[0] + ":" + 
              b[1] + 
              "<Twitch>" +
              b[3].split("!")[0].replace(b[3].split("!")[0].charAt(0), Character.toUpperCase(b[3].split("!")[0].charAt(0))) + 
              ": " +
              b[b.length - 1];