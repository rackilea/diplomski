long top1Points = 0;
long top2Points = 0;
long top3Points = 0;
long top4Points = 0;
long top5Points = 0;
String top1Player = null;
String top2Player = null;
String top3Player = null;
String top4Player = null;
String top5Player = null;

for(OfflinePlayer p : Bukkit.getOfflinePlayers()){//loop threw all players that have ever played
  String uuid = p.getUUID();//get the player's UUID
  long points = plugin.getConfig().getLong("players." + uuid + ".points");//get the player's points

  if(points > top5Points){ //if the player has more points than the top5Points 
    if(points > top4Points){ //if the player has more points than the top4Points
      if(points > top3Points){ //if the player has more points than the top3Points
        if(points > top2Points){ //if the player has more points than the top2Points
          if(points > top1Points){ //if the player has more points than the top1Points
            //store that this player has the #1 points as of now
            top1Points = points;
            top1Player = p.getName();
            continue;
          }
          //store that this player has the #2 points as of now
          top2Points = points;
          top2Player = p.getName();
          continue;
        }
        //store that this player has the #3 points as of now
        top3Points = points;
        top3Player = p.getName();
        continue;
      }
      //store that this player has the #4 points as of now
      top4Points = points;
      top4Player = p.getName();
      continue;
    }
    //store that this player has the #5 points as of now
    top5Points = points;
    top5Player = p.getName();
    continue;
  }