public abstract class MainFragment extends Fragment {

    private SoundPool soundPool;
    private HashMap<Integer, Integer> soundPoolMap;

    public void onCreate() {
        initSounds(getActivity().getApplicationContext());
    }

    public void initSounds(Context context) {
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap(1);
        soundPoolMap.put(R.raw.music1, soundPool.load(context, R.raw.music1, 1));
        soundPoolMap.put(R.raw.music2, soundPool.load(context, R.raw.music2, 1));
    }

    public void playSound(int soundID) {

        float volume = 0.2f;

        // play sound with same right and left volume, with a priority of 1,
        // zero repeats (i.e play once), and a playback rate of 1f
        soundPool.play(soundPoolMap.get(soundID), volume, volume, 1, 0, 1f);
    }

    private void playSoundClick() {
        playSound(R.raw.music1);
    }

    private void playSoundSelect() {
        playSound(R.raw.music2);
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                playSoundClick();
            } else {
                playSoundSelect();
            }
        }
        return true;
    }
}