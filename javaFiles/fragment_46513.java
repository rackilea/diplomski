final Pattern GO_AWAY_BOT = Pattern.compile("^.*!goawaybot(.+)?$");

...

Matcher m = GO_AWAY_BOT.matcher(message);
if (m.matches()) {
  partChannel(channel, m.group(1) != null ? m.group(1) : "Leaving");
}