String ttt = "v=0\n" +
                "o=Z 0 0 IN IP4 127.0.0.1\n" +
                "s=Z\n" +
                "c=IN IP4 127.0.0.1\n" +
                "t=0 0\n" +
                "m=audio 8000 RTP/AVP 3 110 8 0 98 101\n" +
                "a=rtpmap:110 speex/8000\n" +
                "a=rtpmap:98 iLBC/8000\n" +
                "a=fmtp:98 mode=20\n" +
                "a=rtpmap:101 telephone-event/8000\n" +
                "a=fmtp:101 0-15\n" +
                "a=sendrecv";

Pattern pattern = Pattern.compile("c=IN.*");
Matcher matcher = pattern.matcher(ttt);
if (matcher.find())
     System.out.println(matcher.group());