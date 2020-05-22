String str=EntityUtils.toString(rp.getEntity());
Message msg = pThreadHandler.obtainMessage(HANDLER_FROM_HTTP);
Bundle b = new Bundle();
b.putString("result", str);
msg.setData(b);
msg.sendToTarget();