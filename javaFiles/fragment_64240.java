SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
Date breakout_out = sdf.parse("11:51:00");
Date breakout_out_until = sdf.parse("13:10:00");
Date current_time = sdf.parse("12.05.00");

if(current_time.before(breakout_out_until) && current_time.after(breakout_out)) {
    return "BREAK-OUT"
}