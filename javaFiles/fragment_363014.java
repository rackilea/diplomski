SIPml.init(
     function(e){
         var stack =  new SIPml.Stack({realm: 'example.org', impi: 'bob', impu: 'sip:bob@example.org', password: 'mysecret',
                            events_listener: { events: 'started', listener: function(e){
                                        var callSession = stack.newSession('call-audiovideo', {
                                                video_local: document.getElementById('video-local'),
                                                video_remote: document.getElementById('video-remote'),
                                                audio_remote: document.getElementById('audio-remote')
                                            });
                                        callSession.call('alice');
                                    } 
                                }
                        });
                        stack.start();
                    }
            );