double ct = 0;
for (;;) {
      if(t>=1) break;
            //System.out.println(t+" "+e.getValueAt(t));
            for (int i = 0; i < buff.length; i++) {
                double f=lerp(fa,fb,t);
                buff[i] = (short) (Short.MAX_VALUE * 0.5 * Math.sin(Math.PI * 2 * ct));
                toSoundCard[2 * i] = (byte) buff[i];
                toSoundCard[2 * i + 1] = (byte) (buff[i] >> 8);   //(i know i could avoid doing this)
                t += 1.0 / 44100.0;
                ct += f / 44100.0;
            }
            speaker.write(toSoundCard, 0, toSoundCard.length);
        }