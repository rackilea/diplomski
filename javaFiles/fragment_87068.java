int off = payload.length >= 3
       && payload[0] == 0xEF
       && payload[1] == 0xBB
       && payload[2] == 0xBF ? 3 : 0

dos.write(payload, off, payload.length - off);