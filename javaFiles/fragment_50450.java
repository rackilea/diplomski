int m3 = (int) ((new Date().getTime() / 1000L) % 
  Integer.MAX_VALUE);
final int random3 = new Random().nextInt(999) + 26;
int m4 = m3 * random3;

        Intent intent = new Intent(context, vidfolder.class); 
   intent.putExtra("foo", fid);     


      PendingIntent pIntent =
            PendingIntent.getActivity(
                    context,
                    m4,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT
            );