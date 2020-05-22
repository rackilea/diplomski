int highscore = 500;
int playerId = 5;

ContentValues cv=new ContentValues();
cv.put("highscore", highscore);

String where = "id=? AND highscore<?";
String[] whereArgs = {Integer.toString(playerId), Integer.toString(minimalScore};

db.update("scoretable", cv, where , whereArgs);