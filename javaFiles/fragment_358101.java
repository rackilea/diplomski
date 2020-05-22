URL requestUrl = new URL("https://api.twitch.tv/kraken/users/" + bot.botName
        + "/follows/channels/" + gamrCorpsTextField.getText());
HttpURLConnection connection = (HttpUrlConnection) requestUrl.openConnection();

connection.setRequestMethod("PUT");
connection.setRequestProperty("Accept", "application/vnd.twitchtv.v3+json");
connection.setRequestProperty("Authorization", "OAuth <access_token>");
connection.setDoInput(true);
connection.setDoOutput(false);