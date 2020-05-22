package com.example.marketcheckcarsearchapp;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class CarListing implements Parcelable
{
    /* vehicle parameters */
    String make, model, trim, vin, color, condition, transmission, engine, drivetype, seller_type, seller_name, website, city, state;
    int year, price, mileage, cylinders;
    double distance;
    ArrayList<String> images;

    /* carfax parameters */
    boolean one_owner, clean_title;

    /* local variables that may be important */
    int index;
    JSONObject img_json, build, dealer;
    JSONArray img_array;

    public HashMap<String, String> listview_hashmap;

    /* Most strings are default N/A. Most integers are default 1, or 1970 for the case of years. */
    public CarListing(JSONObject input, int index)
    {
        try
        {
            this.images = new ArrayList<>();
            this.index = index;
            this.listview_hashmap = new HashMap<>();

            if(input.has("vin")) this.vin = input.getString("vin");
            else this.vin = "N/A";

            if(input.has("price")) this.price = input.getInt("price");
            else this.price = 1;

            if(input.has("mileage")) this.mileage = input.getInt("mileage");
            else this.mileage = 1;

            if(input.has("vdp_url")) this.website = input.getString("vdp_url");
            else this.website = "N/A";

            if(input.has("carfax_1_owner")) this.one_owner = input.getBoolean("carfax_1_owner");
            else this.one_owner = true;

            if(input.has("carfax_clean_title")) this.clean_title = input.getBoolean("carfax_clean_title");
            else this.clean_title = true;

            if(input.has("exterior_color")) this.color = input.getString("exterior_color");
            else this.color = "N/A";

            if(input.has("seller_type")) this.seller_type = input.getString("seller_type");
            else this.seller_type = "N/A";

            if(input.has("inventory_type")) this.condition = input.getString("inventory_type");
            else this.condition = "N/A";

            if(input.has("build"))
            {
                this.build = input.getJSONObject("build");

                if(this.build.has("year")) this.year = this.build.getInt("year");
                else this.year = 1970;

                if(this.build.has("make")) this.make = this.build.getString("make");
                else this.make = "N/A";

                if(this.build.has("model")) this.model = this.build.getString("model");
                else this.model = "N/A";

                if(this.build.has("trim")) this.trim = this.build.getString("trim");
                else this.trim = "N/A";

                if(this.build.has("transmission")) this.transmission = this.build.getString("transmission");
                else this.transmission = "N/A";

                if(this.build.has("drivetrain")) this.drivetype = this.build.getString("drivetrain");
                else this.drivetype = "N/A";

                if(this.build.has("cylinders")) this.cylinders = this.build.getInt("cylinders");
                else this.cylinders = 4;

                if(this.build.has("engine")) this.engine = this.build.getString("engine");
                else this.engine = "N/A";

                if(this.build.has("dist")) this.distance = this.build.getDouble("dist");
                else this.distance = 0;
            }

            if(input.has("dealer"))
            {
                this.dealer = input.getJSONObject("dealer");
                if(this.dealer.has("name")) this.seller_name = capitalizeLetters(this.dealer.getString("name"));
                else this.seller_name = "N/A";

                if(this.dealer.has("city")) this.city = this.dealer.getString("city");
                else this.city = "N/A";

                if(this.dealer.has("state")) this.state = this.dealer.getString("state");
                else this.state = "N/A";
            }

            if(input.has("media"))
            {
                this.img_json = input.getJSONObject("media");
                if(this.img_json.has("photo_links")) this.img_array = this.img_json.getJSONArray("photo_links");
                else this.img_json = null;

                int n = this.img_array.length();
                for(int i=0;i<n;i++)
                {
                    if(i >= 50) break;
                    else
                    {
                        this.images.add(img_array.getString(i));
                    }
                }
            }
        }
        catch(JSONException ex)
        {
            System.out.println("JSON Exception thrown");
        }
    }

    protected CarListing(Parcel in) {
        make = in.readString();
        model = in.readString();
        trim = in.readString();
        vin = in.readString();
        color = in.readString();
        condition = in.readString();
        transmission = in.readString();
        engine = in.readString();
        drivetype = in.readString();
        seller_type = in.readString();
        seller_name = in.readString();
        website = in.readString();
        city = in.readString();
        state = in.readString();
        year = in.readInt();
        price = in.readInt();
        mileage = in.readInt();
        cylinders = in.readInt();
        distance = in.readDouble();
        images = in.createStringArrayList();
        one_owner = in.readByte() != 0;
        clean_title = in.readByte() != 0;
        index = in.readInt();
    }

    public static final Creator<CarListing> CREATOR = new Creator<CarListing>() {
        @Override
        public CarListing createFromParcel(Parcel in) {
            return new CarListing(in);
        }

        @Override
        public CarListing[] newArray(int size) {
            return new CarListing[size];
        }
    };

    public String capitalizeLetters(String input)
    {
        String[] array = input.split(" ");
        String output = "";
        int n = array.length;
        for(int i=0;i<n;i++)
        {
            String cap = array[i].substring(0, 1).toUpperCase() + array[i].substring(1);
            output += cap;
        }
        return output;
    }

    public void makeHashMap()
    {
        String vehicle_title = Integer.toString(this.year) + this.make + this.model + this.trim;
        String vehicle_information = NumberFormat.getIntegerInstance().format(this.mileage) + " miles | " + this.color + " | " + this.condition + " | $" + NumberFormat.getIntegerInstance().format(this.price);
        String dealer_name = this.seller_name;
        String location = Double.toString(this.distance) + " mi. | " + this.city + ", " + this.state;
        String first_img = this.images.get(0);

        this.listview_hashmap.put("title", vehicle_title);
        this.listview_hashmap.put("information", vehicle_information);
        this.listview_hashmap.put("dealer", dealer_name);
        this.listview_hashmap.put("distance", location);
        this.listview_hashmap.put("first_image", first_img);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(trim);
        dest.writeString(vin);
        dest.writeString(color);
        dest.writeString(condition);
        dest.writeString(transmission);
        dest.writeString(engine);
        dest.writeString(drivetype);
        dest.writeString(seller_type);
        dest.writeString(seller_name);
        dest.writeString(website);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeInt(year);
        dest.writeInt(price);
        dest.writeInt(mileage);
        dest.writeInt(cylinders);
        dest.writeDouble(distance);
        dest.writeStringList(images);
        dest.writeByte((byte) (one_owner ? 1 : 0));
        dest.writeByte((byte) (clean_title ? 1 : 0));
        dest.writeInt(index);
    }
}