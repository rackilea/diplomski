if(soundima == 1){
    soundima = 0;
    SharedPreferences sound = getSharedPreferences(YOUR_CONSTANT,0);
    SharedPreferences.Editor editor = sound.edit();
    editor.putInt("sOn", soundima);
    editor.commit();
}
else if(soundima == 0){
    soundima = 1;
    SharedPreferences sound = getSharedPreferences(YOUR_CONSTANT,0);
    SharedPreferences.Editor editor = sound.edit();
    editor.putInt("sOn", soundima);
    editor.commit();
}