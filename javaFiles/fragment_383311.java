String[] arr = {
    "contentType=application/x-mpegURL, url=https://video.twimg.com/amplify_video/822938952332144642/pl/BjHU8aBCbOgZNzXQ.m3u8}",

    "Variant{bitrate=0, contentType=application/dash+xml, url=https://video.twimg.com/amplify_video/822938952332144642/pl/BjHU8aBCbOgZNzXQ.mpd}",

    "Variant{bitrate=320000, contentType=video/mp4, url=https://video.twimg.com/amplify_video/822938952332144642/vid/320x180/YqZ72rzLj3VWVhy4.mp4}",

    "Variant{bitrate=832000, contentType=video/mp4, url=https://video.twimg.com/amplify_video/822938952332144642/vid/640x360/A2vMgzo2ElpPP6TE.mp4}",

    "Variant{bitrate=2176000, contentType=video/mp4, url=https://video.twimg.com/amplify_video/822938952332144642/vid/1280x720/j9xbNzRZqEbYs_2s.mp4}]}]" 
};
String pattern = "https://.*mp4";
Pattern r = Pattern.compile(pattern);

for (String line : arr) {
    Matcher m = r.matcher(line);
    if (m.find()) {
        System.out.println(m.group(0));
    } else {
        System.out.println("NO MATCH");
    }
}