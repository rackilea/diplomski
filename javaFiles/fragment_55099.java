Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
for (Mixer.Info[] info : mixerInfos) {
    System.out.println("Supported: " + info);
}
if (mixerInfos.length == 0) {
    System.out.println("Audio mixers are not supported.");
}