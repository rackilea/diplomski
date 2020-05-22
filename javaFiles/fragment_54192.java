String startInputFragment = "<input type=\"hidden\" name=\"sessid\" value=\"";
    int startIdx = response.indexOf(startInputFragment);
    if (startIdx >= 0) {
        int endIdx = response.indexOf("\">", startIdx);
        String val = response.substring(startIdx + startInputFragment.length(),
                endIdx);
        System.out.println("-->" + val + "<--");
    } else {
        //tag not found: you may throw an ex or do something else
    }