String updateSkillsoverallSql = "UPDATE skillsoverall"
+ " SET `lvl`=?,"
+ " `xp`=?"
+ " WHERE `playerName`=?";

String updatePlayerRightsSql = "UPDATE playerrights"
+ " SET `rank` = ?"
+ " WHERE `playerName`=?";