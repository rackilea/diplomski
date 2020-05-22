Video ve = listVids[0];
ve.setStatus(...)
ve.setSnippet(...)
...
YouTube.Videos.Update updateVideosRequest = youtube.videos().update("snippet, status", ve);
Video videoResponse = updateVideosRequest.execute();