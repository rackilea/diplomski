public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(
                "json.txt"));

        Tweet tweetObj = gson.fromJson(br, Tweet.class);
        System.out.println(tweetObj.getUser().getId());
    }