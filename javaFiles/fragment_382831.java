Element burnabyStatus = doc.getElementsByClass("main-campus-status").first();
Elements h1 = burnabyStatus.select("h1");
burnabyStatus = h1.get(0);
String b_status = burnabyStatus.text();
TextView tv_b_status = (TextView) findViewById(R.id.b_status);
tv_b_status.setTypeface(tf, Typeface.BOLD);
tv_b_status.setText(b_status);