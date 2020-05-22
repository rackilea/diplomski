long maxLengthOfGame = 5400000;

bool sameDay = matchDate.day() == localDate.day();
bool afterStartTime = localDate.time() >= matchDate.time();

bool nextDay = matchDate.day()+1 == localDate.day();
bool lengthOfCurrentGame = midnight - mathDate.time() + localDate.time();
bool withinTimeLimit = lengthOfCurrentGame < maxLengthOfGame;

if ((sameDay && afterStartTime) || (nextDay && withinTimeLimit)) {
    // Code here
}