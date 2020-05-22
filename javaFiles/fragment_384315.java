power.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            irSend(v);
        }
    });

    volup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            irSend(v);
        }
    });

    voldown.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            irSend(v);
        }
    });
    irData = new SparseArray<String>();
        irData.put(R.id.voldown,
                hex2dec("0000 006d 0022 0003 00a9 00a8 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0040 0015 0015 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 0702 00a9 00a8 0015 0015 0015 0e6e"));
        irData.put(R.id.volup,
                hex2dec("0000 006d 0022 0003 00a9 00a8 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 003f 0015 003f 0015 0702 00a9 00a8 0015 0015 0015 0e6e"));
        irData.put(R.id.power,
                hex2dec("0000 006d 0022 0003 00a9 00a8 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 003f 0015 0015 0015 003f 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 0015 003f 0015 0015 0015 003f 0015 003f 0015 003f 0015 003f 0015 0702 00a9 00a8 0015 0015 0015 0e6e"));



    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

        irInit4KitKat();

    }
}

@TargetApi(Build.VERSION_CODES.KITKAT)
public void irInit4KitKat() {

    // Get a reference to the ConsumerIrManager
    mCIR = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);

}


public void irSend(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){

        irSend4Kitkat(view);
         }
      }

       @TargetApi(Build.VERSION_CODES.KITKAT)
       private void irSend4Kitkat(View view) {

      if(mCIR.hasIrEmitter() == true){
         String data = irData.get(view.getId());
        if (data != null) {
        String values[] = data.split(",");
        int[] pattern = new int[values.length-1];

        for (int i=0; i<pattern.length; i++){
           pattern[i] = Integer.parseInt(values[i+1]);
       }
       Log.e("LOG", mCIR.getCarrierFrequencies()+ "@" +        Integer.parseInt(values[0]) + "@" + pattern);

      mCIR.transmit(Integer.parseInt(values[0]), pattern);
       }
     }else{
           Log.e("LOG", "not supported options");
           Toast.makeText(MainActivity.this , "This device is not Support     infrared." , Toast.LENGTH_LONG).show();
        }
      }



protected String hex2dec(String irData) {
List<String> list = new ArrayList<String>(Arrays.asList(irData
    .split(" ")));
list.remove(0); // dummy
int frequency = Integer.parseInt(list.remove(0), 16); // frequency
list.remove(0); // seq1
list.remove(0); // seq2

for (int i = 0; i < list.size(); i++) {
list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)*26));
}

frequency = (int) (1000000 / (frequency * 0.241246));
    list.add(0, Integer.toString(frequency));

irData = "";
for (String s : list) {
irData += s + ",";
}
return irData;
 }
}