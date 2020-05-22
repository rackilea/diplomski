import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.regions.Regions;

import java.util.List;
import java.util.Locale;

/**
 * Created by App Studio 35 on 7/27/17.
 */
public class CognitoManager {

    /*///////////////////////////////////////////////////////////////
    // CONSTANTS
    *////////////////////////////////////////////////////////////////
    public static class S3BucketInfo {
        public static final String DEV_BUCKET_NAME = "<YOUR-PHOTOS-STAGING-BUCKET>";

        public static final String PRD_BUCKET_NAME = "<YOUR-PHOTOS-PROD-BUCKET>";

    }
    public static class CognitoProviderInfo {
        public static final Regions DEV_REGION = Regions.US_EAST_1;

        public static final Regions PRD_REGION = Regions.US_EAST_1;

    }
    public static class S3ClientInfo {
        public static final String PRD_CLIENT_ACCESS_KEY = "<YOUR-CLIENT-ACCESS-KEY>";
        public static final String PRD_CLIENT_SECRET_KEY = "<YOUR-CLIENT-SECRET-KEY>";

    }
    public static class CognitoUserPoolInfo {
        public static final String DEV_USER_POOL_ID = "us-east-1_<YOUR-LETTERS>"; //DON'T USE EAST IF YOU ARE NOT EAST
        public static final String DEV_APP_PROVIDER_CLIENT_ID = "<YOUR-APP-STAGE-PROVIDER-CLIENT-ID-FOR-ANDROID>";
        public static final String DEV_APP_PROVIDER_CLIENT_SECRET = "<YOUR-APP-STAGE-PROVIDER-CLIENT-SECRET-FOR-ANDROID-PROVIDER>";

        public static final String PRD_USER_POOL_ID = "us-east-1_<YOUR LETTERS>"; //DON'T USE EAST IF YOU ARE NOT EAST
        public static final String PRD_APP_PROVIDER_CLIENT_ID = "<YOUR-APP-PROD-PROVIDER-CLIENT-ID-FOR-ANDROID>";
        public static final String PRD_APP_PROVIDER_CLIENT_SECRET = "<YOUR-APP-PROD-PROVIDER-CLIENT-ID-FOR-ANDROID>";

    }


    /*///////////////////////////////////////////////////////////////
    // MEMBERS
    *////////////////////////////////////////////////////////////////
    private static final String TAG = Globals.SEARCH_STRING + CognitoManager.class.getSimpleName();
    private static CognitoManager mInstance;
    private static CognitoUserPool mUserPool;
    private static String mUser;
    private static boolean mIsEmailVerified;
    private static boolean mIsPhoneVerified;
    private static CognitoUserSession mCurrentUserSession;


    /*///////////////////////////////////////////////////////////////
    // PROPERTIES
    *////////////////////////////////////////////////////////////////
    public static String getUserPoolID(){
        switch (AMEnvironment.getCurrentEnvironment()){
            case DEV:
            case QA:
            case STG:
                return CognitoUserPoolInfo.DEV_USER_POOL_ID;

            case PRD:
            default:
                return CognitoUserPoolInfo.PRD_USER_POOL_ID;

        }

    }
    public static String getClientID(){
        switch (AMEnvironment.getCurrentEnvironment()){
            case DEV:
            case QA:
            case STG:
                return CognitoUserPoolInfo.DEV_APP_PROVIDER_CLIENT_ID;

            case PRD:
            default:
                return CognitoUserPoolInfo.PRD_APP_PROVIDER_CLIENT_ID;

        }

    }
    public static String getClientSecret(){
        switch (AMEnvironment.getCurrentEnvironment()){
            case DEV:
            case QA:
            case STG:
                return CognitoUserPoolInfo.DEV_APP_PROVIDER_CLIENT_SECRET;

            case PRD:
            default:
                return CognitoUserPoolInfo.PRD_APP_PROVIDER_CLIENT_SECRET;

        }

    }
    public static String getS3ClientID(){
        switch (AMEnvironment.getCurrentEnvironment()){
            case DEV:
            case QA:
            case STG:
            case PRD:
            default:
                return S3ClientInfo.PRD_CLIENT_ACCESS_KEY;

        }

    }
    public static String getS3ClientSecret(){
        switch (AMEnvironment.getCurrentEnvironment()){
            case DEV:
            case QA:
            case STG:
            case PRD:
            default:
                return S3ClientInfo.PRD_CLIENT_SECRET_KEY;

        }

    }
    public static String getS3BucketName(){
        switch (AMEnvironment.getCurrentEnvironment()){
            case DEV:
            case QA:
            case STG:
                return S3BucketInfo.DEV_BUCKET_NAME;

            case PRD:
            default:
                return S3BucketInfo.PRD_BUCKET_NAME;

        }
    }
    public static Regions getCognitoRegion(){
        switch (AMEnvironment.getCurrentEnvironment()){
            case DEV:
            case QA:
            case STG:
                return CognitoProviderInfo.DEV_REGION;

            case PRD:
            default:
                return CognitoProviderInfo.PRD_REGION;

        }

    }
    public static void setUser(String user){
        mUser = user;
    }
    public static String getUser(){
        return mUser;
    }
    public static CognitoUserPool getUserPool(){
        return mUserPool;

    }
    public static CognitoUserSession getCurrentUserSession(){
        return mCurrentUserSession;

    }
    public static void setCurrentUserSession(CognitoUserSession session){
        mCurrentUserSession = session;

    }


    /*///////////////////////////////////////////////////////////////
    // INIT
    *////////////////////////////////////////////////////////////////
    public static void init(Context context) {
        if (mInstance != null && mUserPool != null) {
            return;

        }

        if (mInstance == null) {
            mInstance = new CognitoManager();

        }

        if (mUserPool == null) {
            // Create a user pool with default ClientConfiguration
            mUserPool = new CognitoUserPool(context, getUserPoolID(), getClientID(), getClientSecret(), getCognitoRegion());

        }

    }


    /*///////////////////////////////////////////////////////////////
    // EXTERNAL METHODS
    *////////////////////////////////////////////////////////////////
    public static void signInUser(final String user, final String password, final AuthenticationHandler authenticationHandler){
        setUser(user);
        getUserPool().getUser(user).getSessionInBackground(new AuthenticationHandler() {
            @Override
            public void onSuccess(final CognitoUserSession userSession, final CognitoDevice newDevice) {
                setCurrentUserSession(userSession);
                rememberTrustedDevice(newDevice);
                getUserDetails(new GetDetailsHandler() {
                    @Override
                    public void onSuccess(CognitoUserDetails cognitoUserDetails) {
                        try{
                            mIsEmailVerified = Boolean.parseBoolean(cognitoUserDetails.getAttributes().getAttributes().get(Globals.CUSTOM_USER_ATTRIBUTES.IS_EMAIL_VALIDATED_ATTRIBUTE));//"email_verified" is the string
                            //mIsPhoneVerified = Boolean.parseBoolean(cognitoUserDetails.getAttributes().getAttributes().get(Globals.CUSTOM_USER_ATTRIBUTES.IS_EMAIL_VALIDATED_ATTRIBUTE));

                        }catch (Exception ex){


                        }

                        authenticationHandler.onSuccess(userSession, newDevice);

                    }
                    @Override
                    public void onFailure(Exception exception) {
                        authenticationHandler.onSuccess(userSession, newDevice);

                    }
                });

            }
            @Override
            public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String UserId) {
                Locale.setDefault(Locale.US);
                AuthenticationDetails authenticationDetails = new AuthenticationDetails(user, password, null);
                authenticationContinuation.setAuthenticationDetails(authenticationDetails);
                authenticationContinuation.continueTask();
                authenticationHandler.getAuthenticationDetails(authenticationContinuation, UserId);

            }
            @Override
            public void getMFACode(MultiFactorAuthenticationContinuation continuation) {
                authenticationHandler.getMFACode(continuation);

            }
            @Override
            public void authenticationChallenge(ChallengeContinuation continuation) {
                authenticationHandler.authenticationChallenge(continuation);
                //TODO implement "new_password_required" or "phone_needs_verified" or "email_needs_verified" instead of passing back lazily use correct callbacks of phone or password etc.. for cleanliness

            }
            @Override
            public void onFailure(Exception exception) {
                authenticationHandler.onFailure(exception);

            }

        });

    }
    public static void signOutCurrentUser(){
        if(getUserPool().getCurrentUser() != null) {
            getUserPool().getCurrentUser().signOut();

        }

    }
    public static void rememberTrustedDevice(CognitoDevice newDevice){
        if(newDevice != null) {
            newDevice.rememberThisDeviceInBackground(new GenericHandler() {
                @Override
                public void onSuccess() {
                    //not really sure if we need to do anything with this info or not just yet

                }

                @Override
                public void onFailure(Exception exception) {
                    //Faled to save device

                }

            });

        }

    }
    public static void refreshToken(final GenericHandler genericHandler){ //called from background thread to keep session alive
        if(getUserPool() == null || getUserPool().getCurrentUser() == null || getUserPool().getCurrentUser().getUserId() == null){
            genericHandler.onFailure(new Exception("Invalid User Token"));

        }else{
            getUserPool().getCurrentUser().getSessionInBackground(new AuthenticationHandler() {
                @Override
                public void onSuccess(CognitoUserSession userSession, CognitoDevice newDevice) {
                    setCurrentUserSession(userSession);
                    rememberTrustedDevice(newDevice);
                    getUserDetails(new GetDetailsHandler() {
                        @Override
                        public void onSuccess(CognitoUserDetails cognitoUserDetails) {
                            try{
                                mIsEmailVerified = Boolean.parseBoolean(cognitoUserDetails.getAttributes().getAttributes().get(Globals.CUSTOM_USER_ATTRIBUTES.IS_EMAIL_VALIDATED_ATTRIBUTE));
                                //mIsPhoneVerified = Boolean.parseBoolean(cognitoUserDetails.getAttributes().getAttributes().get(Globals.CUSTOM_USER_ATTRIBUTES.IS_PHONE_VALIDATED_ATTRIBUTE)); //not used in my current app

                            }catch (Exception ex){


                            }

                            genericHandler.onSuccess();

                        }
                        @Override
                        public void onFailure(Exception exception) {
                            genericHandler.onSuccess();
                        }
                    });

                }
                @Override
                public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String UserId) {
                    genericHandler.onFailure(new Exception("Invalid User Token"));

                }
                @Override
                public void getMFACode(MultiFactorAuthenticationContinuation continuation) {
                    genericHandler.onFailure(new Exception("Invalid User Token"));

                }
                @Override
                public void authenticationChallenge(ChallengeContinuation continuation) {
                    genericHandler.onFailure(new Exception("Invalid User Token"));

                }
                @Override
                public void onFailure(Exception exception) {
                    genericHandler.onFailure(new Exception("Invalid User Token"));

                }

            });

        }

    }
    /**
     * Used to update cached booleans for isEmailVerified or isPhoneVerified
     */
    public static void phoneOrEmailChanged(){
        if(getUserPool().getCurrentUser() == null){
            return;

        }

        getUserDetails(new GetDetailsHandler() {
            @Override
            public void onSuccess(CognitoUserDetails cognitoUserDetails) {
                try{
                    mIsEmailVerified = Boolean.parseBoolean(cognitoUserDetails.getAttributes().getAttributes().get(Globals.CUSTOM_USER_ATTRIBUTES.IS_EMAIL_VALIDATED_ATTRIBUTE));
                    //mIsPhoneVerified = Boolean.parseBoolean(cognitoUserDetails.getAttributes().getAttributes().get(Globals.CUSTOM_USER_ATTRIBUTES.IS_PHONE_VALIDATED_ATTRIBUTE)); //"phone_number" is string, but not used in my current app

                }catch (Exception ex){


                }

            }
            @Override
            public void onFailure(Exception exception) {

            }

        });

    }
    public static boolean isPhoneVerified(){
        return true; //for now we are not verifying phone
        //return mIsPhoneVerified;
    }
    public static boolean isEmailVerified(){
        return mIsEmailVerified;
    }
    public static void getUserDetails(GetDetailsHandler handler){
        getUserPool().getCurrentUser().getDetailsInBackground(handler);

    }
    public static void updatePhoneNumber(String phone, final GenericHandler handler){
        CognitoUserAttributes userAttributes = new CognitoUserAttributes();
        userAttributes.addAttribute(Globals.CUSTOM_USER_ATTRIBUTES.PHONE_ATTRIBUTE, PhoneNumberHelper.getStrippedNumberWithCountryCode(phone));

        CognitoManager.getUserPool().getUser(CognitoManager.getUserPool().getCurrentUser().getUserId()).updateAttributesInBackground(userAttributes, new UpdateAttributesHandler() {
            @Override
            public void onSuccess(List<CognitoUserCodeDeliveryDetails> attributesVerificationList) {
                handler.onSuccess();

            }
            @Override
            public void onFailure(Exception exception) {
                handler.onFailure(exception);

            }

        });
    }
    public static void updateEmail(String email, final GenericHandler handler){
        CognitoUserAttributes userAttributes = new CognitoUserAttributes();
        userAttributes.addAttribute(Globals.CUSTOM_USER_ATTRIBUTES.EMAIL_ATTRIBUTE, email);
        CognitoManager.getUserPool().getUser(CognitoManager.getUserPool().getCurrentUser().getUserId()).updateAttributesInBackground(userAttributes, new UpdateAttributesHandler() {
            @Override
            public void onSuccess(List<CognitoUserCodeDeliveryDetails> attributesVerificationList) {
                handler.onSuccess();

            }
            @Override
            public void onFailure(Exception exception) {
                handler.onFailure(exception);
            }

        });

    }
    public static void updatePassword(String oldPassword, String newPassword, final GenericHandler handler){
        getUserPool().getUser().changePasswordInBackground(oldPassword, newPassword, new GenericHandler() {
            @Override
            public void onSuccess() {
                handler.onSuccess();

            }
            @Override
            public void onFailure(Exception exception) {
                handler.onFailure(exception);
            }

        });
    }
    public static void forgotPassword(String email, final ForgotPasswordHandler handler){
        getUserPool().getUser(email).forgotPasswordInBackground(new ForgotPasswordHandler() {
            @Override
            public void onSuccess() {
                handler.onSuccess();
            }
            @Override
            public void getResetCode(ForgotPasswordContinuation continuation) {
                handler.getResetCode(continuation);
            }
            @Override
            public void onFailure(Exception exception) {
                handler.onFailure(exception);

            }

        });
    }
    public static void sendVerificationEmail(final VerificationHandler handler){
        getUserPool().getCurrentUser().getAttributeVerificationCodeInBackground(Globals.CUSTOM_USER_ATTRIBUTES.PHONE_ATTRIBUTE, new VerificationHandler() {
            @Override
            public void onSuccess(CognitoUserCodeDeliveryDetails verificationCodeDeliveryMedium) {
                handler.onSuccess(verificationCodeDeliveryMedium);

            }
            @Override
            public void onFailure(Exception exception) {
                handler.onFailure(exception);

            }

        });

    }
    public static void sendVerificationText(final VerificationHandler handler){
        getUserPool().getCurrentUser().getAttributeVerificationCodeInBackground(Globals.CUSTOM_USER_ATTRIBUTES.PHONE_ATTRIBUTE, new VerificationHandler() {
            @Override
            public void onSuccess(CognitoUserCodeDeliveryDetails verificationCodeDeliveryMedium) {
                handler.onSuccess(verificationCodeDeliveryMedium);

            }
            @Override
            public void onFailure(Exception exception) {
                handler.onFailure(exception);

            }

        });

    }
    public static void verifyAttributesInBackground(String attribute, String code, final GenericHandler handler){
        CognitoManager.getUserPool().getCurrentUser().verifyAttributeInBackground(attribute, code, new GenericHandler() {
            @Override
            public void onSuccess() {
                handler.onSuccess();

            }
            @Override
            public void onFailure(Exception exception) {
                handler.onFailure(exception);

            }

        });

    }

}