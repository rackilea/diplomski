outerloop:
for (i = 0; i < 8 ; i++) {
    Cursor r = db.rawQuery("SELECT _id, key_foodstuff, key_calorie, key_carbohydrate, key_fat, key_protein FROM (food INNER JOIN categories ON food.key_nocategory = categories.nocategories) WHERE key_type!='secondary' AND _id!=164 ORDER BY RANDOM() LIMIT 1", null);       

    if(r.moveToFirst())
    {
            morning_food[i] = r.getString(0);
            Log.v("_id : ", morning_food[i]);
            morning_food[c] = r.getString(2);
            Log.v("Kalori : ", morning_food[c]);
            sumOfCalorie = sumOfCalorie + Double.parseDouble(morning_food [c]);
            Log.v("Sum : ", "" + sumOfCalorie);

            if (sumOfCalorie == morning_cal || sumOfCalorie >= morning_cal-(morning_cal*0.1) && sumOfCalorie <= morning_cal+(morning_cal*0.1))
            {
                break outerloop;
            }


    }