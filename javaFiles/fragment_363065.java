sb.append("INSERT INTO `TOOLS_USERS` VALUES(");
sb.append("'%name%',");
sb.append("'%firstip%',");
sb.append("'%ip%',");
sb.append("%mute%,");
sb.append("%mutereason%,");
sb.append("TIME=%time%**,**"); <- The error is the following comma. Try to erase it and compile again.
sb.append(") ON DUPLICATE KEY UPDATE ");
sb.append("FIRSTIP='%firstip%',");
sb.append("IP='%ip%',");
sb.append("MUTE=%mute%,");
sb.append("MUTEREASON=%mutereason%;");