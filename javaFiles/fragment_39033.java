- AdActivity.java

package com.android.ads;

import android.app.Activity;
import android.os.Bundle;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class AdsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        AdView adview = (AdView) findViewById(R.id.adView);
        AdRequest re = new AdRequest();
        re.setTesting(true);
        re.setGender(AdRequest.Gender.FEMALE);
        adview.loadAd(re);
    }
}

 - main.xml

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"

        xmlns:ads="http://schemas.android.com/apk/res/com.android.ads"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="vertical" >

    <TextView
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="@string/hello" />

     <com.google.ads.AdView
        android:id="@+id/adView"
        android:layout_width="fill_parent" 
        android:layout_height="wrap_content"
        ads:adSize="BANNER"
        ads:adUnitId="Your adunit ID" 
        android:layout_alignParentBottom="true"/>    
</LinearLayout>

Remember Put GoogleMapAdmobSdk.jar after creating libs folder for Configure build path 


Create the attrs.xml in the Values folder

<?xml version="1.0" encoding="utf-8"?>
<resources>
  <declare-styleable name="com.google.ads.AdView">
      <attr name="adSize">
          <enum name="BANNER" value="1"/>
          <enum name="IAB_MRECT" value="2"/>
          <enum name="IAB_BANNER" value="3"/>
          <enum name="IAB_LEADERBOARD" value="4"/>
      </attr>
      <attr name="adUnitId" format="string"/>
  </declare-styleable>
</resources>

 - AndroidManifest

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.android.ads"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-sdk android:minSdkVersion="8" />
 <uses-permission android:name="android.permission.INTERNET"/>
  <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

    <application
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name" >
        <activity
            android:name=".AdsActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>


        <activity android:name="com.google.ads.AdActivity"
                      android:configChanges="keyboard|keyboardHidden|orientation"/>
    </application>

</manifest>


Your work is done buddy............