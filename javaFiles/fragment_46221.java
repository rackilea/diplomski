package com.st.BlueSTSDK.Example;

import android.content.Context;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.st.BlueSTSDK.Feature;
import com.st.BlueSTSDK.Features.FeatureAudioADPCM;
import com.st.BlueSTSDK.Features.FeatureAudioADPCMSync;
import com.st.BlueSTSDK.Manager;
import com.st.BlueSTSDK.Node;
import com.st.BlueSTSDK.Utils.BVAudioSyncManager;

import java.util.List;


public class FeatureAudioActivity extends AppCompatActivity {

/**
 *   Node that will show the data
 */
private Node mNode;

/** fragment used for keep the connection open */
private NodeContainerFragment mNodeContainer;

//  Feature on which to apply the listener
private FeatureAudioADPCM mAudio;

// feature where we read the audio sync values
private FeatureAudioADPCMSync mAudioSync;

// The sampling rate
private static final int SAMPLE_RATE = 8000;

// audio manager
private static final int AUDIO_STREAM = AudioManager.STREAM_MUSIC;

//  Audio track builder
private AudioTrack mAudioTrack;

//object containing the sync data needed in a ADPCM stream decoding
private BVAudioSyncManager mBVAudioSyncManager = new BVAudioSyncManager();


private final static String NODE_FRAGMENT =   FeatureAudioActivity.class.getCanonicalName() + "" +
        ".NODE_FRAGMENT";
private final static String NODE_TAG = FeatureAudioActivity.class.getCanonicalName() + "" +
        ".NODE_TAG";



/**
 * create an intent for start the activity that will log the information from the node
 *
 * @param c    context used for create the intent
 * @param node note that will be used by the activity
 * @return intent for start this activity
 */
public static Intent getStartIntent(Context c, @NonNull Node node) {
    Intent i = new Intent(c, FeatureAudioActivity.class);
    i.putExtra(NODE_TAG, node.getTag());
    i.putExtras(NodeContainerFragment.prepareArguments(node));
    return i;
}

/**
 * listener for the audio feature, it will updates the audio values
 */
public final Feature.FeatureListener mAudioListener = new Feature.FeatureListener() {

    @Override
    public void onUpdate(final Feature f, final Feature.Sample sample) {
        short audioSample[] = FeatureAudioADPCM.getAudio(sample);

          /*Write audio data for playback
          @param short : The array that contains the data for playback
          @param int: offset in rawAudio where playback data begins
          @param int: The number of shorts to read in rawAudio after the offset
            */
        mAudioTrack.write(audioSample,0,audioSample.length);
    }

};

/**
 * listener for the audioSync feature, it will update the synchronism values
 */
public final Feature.FeatureListener mAudioSyncListener = new Feature.FeatureListener() {
    @Override
    public void onUpdate(Feature f, final Feature.Sample sample) {
        if(mBVAudioSyncManager!=null){
            mBVAudioSyncManager.setSyncParams(sample);
        }
    }
};

/* ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// */
private SeekBar mVolumeBar;
private AudioManager mAudioManager;

private Button mPlayButton;
private Button mStopButton;

private ImageButton mMuteButton;
private boolean mIsMute = false;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_feature_audio);

    // find the node.
    String nodeTag = getIntent().getStringExtra(NODE_TAG);
    mNode = Manager.getSharedInstance().getNodeWithTag(nodeTag);


    List<Feature> listFeature = mNode.getFeatures();
    for (Feature f : listFeature) {
        if (f.isEnabled() && f.getName().equals("AudioFeature")) {

            mAudio=(FeatureAudioADPCM) f;

        }//if
        if (f.isEnabled() && f.getName().equals("AudioSyncFeature")) {

            mAudioSync=(FeatureAudioADPCMSync) f;

        }//if
    }//for


    //create/recover the NodeContainerFragment
    if (savedInstanceState == null) {
        Intent i = getIntent();
        mNodeContainer = new NodeContainerFragment();
        mNodeContainer.setArguments(i.getExtras());
        getFragmentManager().beginTransaction()
                .add(mNodeContainer, NODE_FRAGMENT).commit();
    } else {
        mNodeContainer = (NodeContainerFragment) getFragmentManager()
                .findFragmentByTag(NODE_FRAGMENT);
    }//if-else



    //builder audio track
    mAudioTrack = new AudioTrack(
            AudioManager.STREAM_MUSIC,
            SAMPLE_RATE,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            FeatureAudioADPCM.AUDIO_PACKAGE_SIZE,
            AudioTrack.MODE_STREAM);



    mPlayButton = (Button) findViewById(R.id.playButton);
    mStopButton = (Button) findViewById(R.id.stopButton);
    mMuteButton = (ImageButton) findViewById(R.id.muteButton);



    //  When the play button is pressed
    mPlayButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(!mIsMute){
                mAudioTrack.play();
                mAudioManager.setStreamVolume(AUDIO_STREAM,mVolumeBar.getProgress(),0);
            }

        }
    });

    //When the stop button is pressed
    mStopButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            stopAudioTrack();
            mAudioManager.setStreamVolume(AUDIO_STREAM,0,0);

        }
    });

    //When the mute button is pressed
    mMuteButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeState();
        }
        boolean changeState(){
            mIsMute=!mIsMute;
            if(mIsMute)
                muteAudio();
            else
                unMuteAudio();
            return mIsMute;
        }
        private void muteAudio(){
            mMuteButton.setImageResource(R.drawable.ic_volume_off_black_32dp);
            mAudioManager.setStreamVolume(AUDIO_STREAM,0,0);
            mVolumeBar.setEnabled(false);
        }

        private void unMuteAudio(){
            mMuteButton.setImageResource(R.drawable.ic_volume_up_black_32dp);
            mAudioManager.setStreamVolume(AUDIO_STREAM,mVolumeBar.getProgress(),0);
            mVolumeBar.setEnabled(true);
        }
    });

    //enable control volume
    setVolumeControlStream(AudioManager.STREAM_MUSIC);
    initControls();


}

@Override
public void onResume(){
    super.onResume();
    // enable needed notification
    if(mAudio!=null && mAudioSync!=null) {
        mAudio.addFeatureListener(mAudioListener);
        mBVAudioSyncManager.reinitResetFlag();
        mAudio.setAudioSyncManager(mBVAudioSyncManager);
        mNode.enableNotification(mAudio);
        mAudioSync.addFeatureListener(mAudioSyncListener);
        mNode.enableNotification(mAudioSync);
    }
}

@Override
public void onPause(){
    super.onPause();
    // disable needed notification
    if(mAudio!=null) {
        mAudio.removeFeatureListener(mAudioListener);
        mNode.disableNotification(mAudio);
    }
    if(mAudioSync!=null) {
        mAudioSync.removeFeatureListener(mAudioSyncListener);
        mNode.disableNotification(mAudioSync);
    }
}



private void stopAudioTrack(){
    synchronized(this) {
        mAudioTrack.pause();
        mAudioTrack.flush();
    }
}



//   Volume control from SeekBar
private void initControls()
{
    try
    {
        mVolumeBar = (SeekBar)findViewById(R.id.volumeValue);
        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        mVolumeBar.setMax(mAudioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        mVolumeBar.setProgress(mAudioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC));


        mVolumeBar.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onStopTrackingTouch(SeekBar arg0)
            {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0)
            {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
            {
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
            }
        });
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

/**
 * if we have to leave this activity, we force to keep the connection open, since we go back
 * in the {@link FeatureListActivity}
 */
@Override
public void onBackPressed() {
    mNodeContainer.keepConnectionOpen(true);
    super.onBackPressed();
}//onBackPressed