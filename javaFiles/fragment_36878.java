static void playerEventCallbackA(void *clientData, SuperpoweredAdvancedAudioPlayerEvent event, void *value) {
        SuperpoweredAdvancedAudioPlayer *playerA = *((SuperpoweredAdvancedAudioPlayer **)clientData);
        if (event == SuperpoweredAdvancedAudioPlayerEvent_LoadSuccess) {
            // handle player prepared
        } else if (event == SuperpoweredAdvancedAudioPlayerEvent_LoadError) {
            // handle error with player
        } else if (event == SuperpoweredAdvancedAudioPlayerEvent_EOF && !loopingA) {
            playerA->pause();
        }
    }