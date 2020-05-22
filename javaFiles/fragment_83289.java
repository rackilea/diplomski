// need to call this for the first time
SoundPoolManager.instantiate(context);

// play the sound based on the index
SoundPoolManager.playSound(index);

// clear up the SoundPool when you don't need it anymore.
SoundPoolManager.cleanUp();