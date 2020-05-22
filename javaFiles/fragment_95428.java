package Testers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TweetReader {

    public static List<Tweet> readTweets(File file) throws IOException {
        boolean processEnd = false;
        String type = "";
        String origin = "";
        String tweetText = "";
        String url = "";
        String tweetID = "";
        String tweetDate = "";
        int retCount = 0;
        String favourite = "";
        String mEntities = "";
        String hashTags = "";
        List<Tweet> tweets = new ArrayList<Tweet>();
        List<String> lines = Files.readAllLines(file.toPath());
        for(int i = 0; i < lines.size(); i++){
            String line = lines.get(i);
            line = line.trim();
            if(line.equals("***")){
                if(processEnd){
                    Tweet tweet = new Tweet(type, origin, tweetText, url, tweetID, tweetDate, retCount, favourite, mEntities, hashTags);
                    tweets.add(tweet);
                    processEnd = false;
                }else processEnd = true;
            }else{
                if(line.contains(":")){
                    String header = line.substring(0, line.indexOf(":"));
                    //System.out.println(header); //You can uncomment this for troubleshooting
                    if(header.equals("Type")) type = line.substring(line.length() > 5 ? 5 : line.length());
                    else if(header.equals("Origin")) origin = line.substring(line.length() > 8 ? 8 : line.length());
                    else if(header.equals("Text")) tweetText = line.substring(line.length() > 6 ? 6 : line.length());
                    else if(header.equals("URL")) url = line.substring(line.length() > 5 ? 5 : line.length());
                    else if(header.equals("ID")) tweetID = line.substring(line.length() > 4 ? 4 : line.length());
                    else if(header.equals("Time")) tweetDate = line.substring(line.length() > 6 ? 6 : line.length());
                    else if(header.equals("RetCount")) retCount = Integer.parseInt(line.substring(line.length() > 10 ? 10 : line.length()));
                    else if(header.equals("Favorite")) favourite = line.substring(line.length() > 11 ? 11 : line.length());
                    else if(header.equals("MentionedEntities")) mEntities = line.substring(line.length() > 19 ? 19 : line.length());
                    else if(header.equals("Hashtags")) hashTags = line.substring(line.length() > 10 ? 10 : line.length());
                    else throw new IOException("Line cannot be identified as part of a tweet:" + line);
                }else throw new IOException("Line cannot be processed:" + line);
            }
       }
        return tweets;
    }

    public static void main(String[] args){
        File log = new File("log.txt");
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            File f = new File(".").getAbsoluteFile();
            File[] array = f.listFiles();
            for(int i = 0; i < array.length; i++){
                File tweet = array[i];  
                if(tweet.isFile() && !tweet.getName().contains("log.txt") && !tweet.getName().contains(".jar")){
                    log("Reading file: " + tweet.getAbsolutePath(), log);
                    List<Tweet> tweetlist = readTweets(tweet);
                    tweets.addAll(tweetlist);
                }   
            }
            System.out.println("Reading tweets now");
            for(int i = 0; i < tweets.size(); i++){
                Tweet t = tweets.get(i);
                log("Type = " + t.getType(), log);
                log("Origin = " + t.getOrigin(), log);
                log("Text = " + t.getTweetText(), log);
                log("URL = " + t.getURL(), log);
                log("ID = " + t.getTweetID(), log);
                log("Date = " + t.getTweetDate(), log);
                log("Ret count = " + t.getRetCount(), log);
                log("Favourite = " + t.getFavourite(), log);
                log("Mentioned entities = " + t.getMentionedEntities(), log);
                log("Hashtags = " + t.getHashtags(), log);
                log("Tweet finished", log);
            }
        } catch (IOException e) {
            log(e, log);
        } 
        log("Finished reading tweets.", log);
    }

    private static void log(IOException e, File log) {
        log(e.getMessage(), log);
        StackTraceElement[] array = e.getStackTrace();
        for(int i = 0; i < array.length; i++){
            log("        " + array[i], log);
        }
    }

    private static void log(String string, File log) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(log, true));
            writer.write(string);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}