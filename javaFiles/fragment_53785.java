mdata = ffprobe(function(metadata){ },inPath)

        var parts = mdata['duration'].split(":");
        var hours = parts[0];
        var minutes = parts[1];
        var seconds = parts[2];
        var durationSec = 3600 * parseFloat(hours) + 60 * parseFloat(minutes) + parseFloat(seconds);

        var distance = Math.round(durationSec/5);       

        var args = outPath ? [
            '-ss', distance ,
            '-i', inPath ,
            '-f', 'image2',
            '-vframes', count || 1,
            '-aspect', '4:3',
            '-filter:vf', 'select=\'isnan(prev_selected_t)+gte(t-prev_selected_t\\,'+ distance +')\',' + 'scale=\'if(gt(a,4/3),206,-1)\':' + 
            '\'if(gt(a,4/3),-1,154)\',' + 
            'pad=w=206:h=155:x=(ow-iw)/2:y=(oh-ih)/2:color=black,tile=4x1',
            '-y',



            outPath
        ] : [
            '-i', inPath
        ];