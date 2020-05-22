long[] sens_ids = new long[getSym.length];  
        for (int i = 0; i < getSym.length; i++) {  
          sens_checked_ids[i] = Long.valueOf(getSym[i]);  
        }  
        Bundle mybundle = new Bundle();
       mybundle.putLongArray("sens ids", sens_ids);
       Intent final_intent = new Intent(DetailActivity.this,FinalActivity.class);
                final_intent.putExtras(mybundle);
                startActivity(final_intent);