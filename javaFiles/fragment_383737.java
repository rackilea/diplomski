package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.sdk.InMobiSdk;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mopub.common.util.Json.getJsonValue;
import static com.mopub.common.util.Numbers.parseDouble;
import static com.mopub.nativeads.NativeImageHelper.preCacheImages;

/*
 * Tested with InMobi SDK 5.2.3
 */
public class InMobiNative extends CustomEventNative {


    private static boolean isAppIntialize = false;
    private JSONObject serverParams;
    private String accountId="XXX";
    private long placementId=123L;


    @Override
    protected void loadNativeAd(@NonNull Activity arg0,
                                @NonNull CustomEventNativeListener arg1,
                                @NonNull Map<String, Object> arg2,
                                @NonNull Map<String, String> arg3) {

        // TODO Auto-generated method stub
        Log.d("InMobiNativeCustomEvent", "Reached native adapter");
        try {
            serverParams = new JSONObject(arg3);
        } catch (Exception e) {
            Log.e("InMobi", "Could not parse server parameters");
            e.printStackTrace();
        }

        Activity activity = null;
        if (arg0 instanceof Activity) {
            activity = arg0;
        } else {
            // You may also pass in an Activity Context in the localExtras map
            // and retrieve it here.
        }
        if (activity == null) {
            arg1.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        try {
            accountId = serverParams.getString("accountid");
            placementId = serverParams.getLong("placementId");
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (!isAppIntialize) {
            try {

                InMobiSdk.init(activity,"accountid");
            } catch (Exception e) {
                e.printStackTrace();
            }
            isAppIntialize = true;
        }
        InMobiSdk.setAreaCode("areacode");
        InMobiSdk.setEducation(InMobiSdk.Education.HIGH_SCHOOL_OR_LESS);
        InMobiSdk.setGender(InMobiSdk.Gender.MALE);
        InMobiSdk.setIncome(1000);
        InMobiSdk.setAge(23);
        InMobiSdk.setPostalCode("postalcode");
        InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
        InMobiSdk.setLocationWithCityStateCountry("blore", "kar", "india");
        InMobiSdk.setLanguage("ENG");
        InMobiSdk.setInterests("dance");
        InMobiSdk.setEthnicity(InMobiSdk.Ethnicity.ASIAN);
        InMobiSdk.setYearOfBirth(1980);
        Map<String, String> map = new HashMap<String, String>();
        map.put("tp", "c_mopub");
        map.put("tp-ver", MoPub.SDK_VERSION);
        final InMobiStaticNativeAd inMobiStaticNativeAd =
                new InMobiStaticNativeAd(arg0,
                        new ImpressionTracker(arg0),
                        new NativeClickHandler(arg0),
                        arg1);
        inMobiStaticNativeAd.setIMNative(new com.inmobi.ads.InMobiNative(placementId, inMobiStaticNativeAd));
        inMobiStaticNativeAd.setExtras(map);
        inMobiStaticNativeAd.loadAd();
    }


    static class InMobiStaticNativeAd extends StaticNativeAd implements com.inmobi.ads.InMobiNative.NativeAdListener {
        static final int IMPRESSION_MIN_TIME_VIEWED = 1000;

        // Modifiable keys
        static final String TITLE = "title";
        static final String DESCRIPTION = "description";
        static final String SCREENSHOTS = "screenshots";
        static final String ICON = "icon";
        static final String LANDING_URL = "landingURL";
        static final String CTA = "cta";
        static final String RATING = "rating";

        // Constant keys
        static final String URL = "url";

        private final Context mContext;
        private final CustomEventNativeListener mCustomEventNativeListener;
        private final ImpressionTracker mImpressionTracker;
        private final NativeClickHandler mNativeClickHandler;
        private com.inmobi.ads.InMobiNative mImNative;

        InMobiStaticNativeAd(final Context context,
                             final ImpressionTracker impressionTracker,
                             final NativeClickHandler nativeClickHandler,
                             final CustomEventNativeListener customEventNativeListener) {
            InMobiSdk.init(context,"9107a61fcda34c969d3f74934a352dcb");
            mContext = context.getApplicationContext();
            mImpressionTracker = impressionTracker;
            mNativeClickHandler = nativeClickHandler;
            mCustomEventNativeListener = customEventNativeListener;
        }

        void setIMNative(final com.inmobi.ads.InMobiNative imNative) {
            mImNative = imNative;
        }

        void setExtras(Map<String,String> map){
            mImNative.setExtras(map);
        }

        void loadAd() {
            mImNative.load();
        }


        // Lifecycle Handlers
        @Override
        public void prepare(final View view) {
            if (view != null && view instanceof ViewGroup) {
                com.inmobi.ads.InMobiNative.bind((ViewGroup)view, mImNative);
            } else if (view != null && view.getParent() instanceof ViewGroup) {
                com.inmobi.ads.InMobiNative.bind((ViewGroup)(view.getParent()), mImNative);
            } else {
                Log.e("MoPub", "InMobi did not receive ViewGroup to attachToView, unable to record impressions");
            }
            mImpressionTracker.addView(view, this);
            mNativeClickHandler.setOnClickListener(view, this);
        }

        @Override
        public void clear(final View view) {
            mImpressionTracker.removeView(view);
            mNativeClickHandler.clearOnClickListener(view);
        }

        @Override
        public void destroy() {
            //InMobiNative.unbind(arg0);
            mImpressionTracker.destroy();
        }

        // Event Handlers
        @Override
        public void recordImpression(final View view) {
            notifyAdImpressed();
        }

        @Override
        public void handleClick(final View view) {
            notifyAdClicked();
            mNativeClickHandler.openClickDestinationUrl(getClickDestinationUrl(), view);
            mImNative.reportAdClick(null);
        }

        void parseJson(final com.inmobi.ads.InMobiNative inMobiNative) throws JSONException  {
            final JSONTokener jsonTokener = new JSONTokener((String) inMobiNative.getAdContent());
            final JSONObject jsonObject = new JSONObject(jsonTokener);

            setTitle(getJsonValue(jsonObject, TITLE, String.class));
            String text = getJsonValue(jsonObject, DESCRIPTION, String.class);
            if(text!=null)
                setText(text);
            final JSONObject screenShotJsonObject = getJsonValue(jsonObject, SCREENSHOTS, JSONObject.class);
            if (screenShotJsonObject != null) {
                setMainImageUrl(getJsonValue(screenShotJsonObject, URL, String.class));
            }

            final JSONObject iconJsonObject = getJsonValue(jsonObject, ICON, JSONObject.class);
            if (iconJsonObject != null) {
                setIconImageUrl(getJsonValue(iconJsonObject, URL, String.class));
            }

            final String clickDestinationUrl = getJsonValue(jsonObject, LANDING_URL, String.class);
            if (clickDestinationUrl == null) {
                final String errorMessage = "InMobi JSON response missing required key: "
                        + LANDING_URL + ". Failing over.";
                MoPubLog.d(errorMessage);
                throw new JSONException(errorMessage);
            }

            setClickDestinationUrl(clickDestinationUrl);
            String cta = getJsonValue(jsonObject, CTA, String.class);
            if(cta!=null)
                setCallToAction(cta);
            try {
                if(jsonObject.opt(RATING)!=null){
                    setStarRating(parseDouble(jsonObject.opt(RATING)));
                }
            } catch (ClassCastException e) {
                Log.d("MoPub", "Unable to set invalid star rating for InMobi Native.");
            }            setImpressionMinTimeViewed(IMPRESSION_MIN_TIME_VIEWED);
        }

        @Override
        public void onAdDismissed(com.inmobi.ads.InMobiNative inMobiNative) {
            // TODO Auto-generated method stub
            Log.d("InMobiNativeCustomEvent","Native Ad is dismissed");
        }

        @Override
        public void onAdDisplayed(com.inmobi.ads.InMobiNative inMobiNative) {
            // TODO Auto-generated method stub
            Log.d("InMobiNativeCustomEvent","Native Ad is displayed");
        }

        @Override
        public void onAdLoadFailed(com.inmobi.ads.InMobiNative arg0, InMobiAdRequestStatus arg1) {
            // TODO Auto-generated method stub
            Log.d("InMobiNativeCustomEvent","Native ad failed to load");
            String errorMsg="";
            switch (arg1.getStatusCode()) {
                case INTERNAL_ERROR:
                    errorMsg="INTERNAL_ERROR";
                    break;
                case REQUEST_INVALID:
                    errorMsg="INVALID_REQUEST";
                    break;
                case NETWORK_UNREACHABLE:
                    errorMsg="NETWORK_UNREACHABLE";
                    break;
                case NO_FILL:
                    errorMsg="NO_FILL";
                    break;
                case REQUEST_PENDING:
                    errorMsg="REQUEST_PENDING";
                    break;
                case REQUEST_TIMED_OUT:
                    errorMsg="REQUEST_TIMED_OUT";
                    break;
                case SERVER_ERROR:
                    errorMsg="SERVER_ERROR";
                    break;
                case AD_ACTIVE:
                    errorMsg="AD_ACTIVE";
                    break;
                case EARLY_REFRESH_REQUEST:
                    errorMsg="EARLY_REFRESH_REQUEST";
                    break;
                default:
                    errorMsg="NETWORK_ERROR";
                    break;
            }
            if (errorMsg == "INVALID_REQUEST") {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_REQUEST);
            } else if (errorMsg == "INTERNAL_ERROR" || errorMsg == "NETWORK_ERROR") {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
            } else if (errorMsg == "NO_FILL") {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
            } else if (errorMsg == "REQUEST_TIMED_OUT"){
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NETWORK_TIMEOUT);
            }else if(errorMsg == "NETWORK_UNREACHABLE"){
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.CONNECTION_ERROR);
            }
            else {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            }
        }


        @Override
        public void onUserLeftApplication(com.inmobi.ads.InMobiNative arg0) {
            // TODO Auto-generated method stub
            Log.d("InMobiNativeCustomEvent","User left application");
        }

        @Override
        public void onAdLoadSucceeded(com.inmobi.ads.InMobiNative inMobiNative) {
            // TODO Auto-generated method stub
            Log.v("InMobiNativeCustomEvent", "Ad loaded:"+inMobiNative.getAdContent().toString());
            try {
                parseJson(inMobiNative);
            } catch (JSONException e) {
                mCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
                return;
            }

            final List<String> imageUrls = new ArrayList<String>();
            /*final String mainImageUrl = getMainImageUrl();
            if (mainImageUrl != null) {
                imageUrls.add(mainImageUrl);
            }*/

            final String iconUrl = getIconImageUrl();
            if (iconUrl != null) {
                imageUrls.add(iconUrl);
            }

            preCacheImages(mContext, imageUrls, new NativeImageHelper.ImageListener() {
                @Override
                public void onImagesCached() {
                    Log.v("InMobiNativeCustomEvent", "image cached");
                    mCustomEventNativeListener.onNativeAdLoaded(InMobiStaticNativeAd.this);
                }

                @Override
                public void onImagesFailedToCache(NativeErrorCode errorCode) {
                    Log.v("InMobiNativeCustomEvent", "image failed to cache");
                    mCustomEventNativeListener.onNativeAdFailed(errorCode);
                }
            });
        }


    }
}