int data2WAVstruct(unsigned short channels, unsigned short bipsa, unsigned int samplerate, unsigned int datalength, void* data, WAVstruct result)
{
    result->headertag[0] = 'R';
    result->headertag[1] = 'I';
    result->headertag[2] = 'F';
    result->headertag[3] = 'F';
    result->remnantlength = 44 + datalength - 8;
    result->fileid[0] = 'W';
    result->fileid[1] = 'A';
    result->fileid[2] = 'V';
    result->fileid[3] = 'E';

    result->fmtchunktag[0] = 'f';
    result->fmtchunktag[1] = 'm'; 
    result->fmtchunktag[2] = 't';
    result->fmtchunktag[3] = ' ';
    result->fmtlength = 0x00000010;
    result->fmttag = 1;
    result->channels = channels;
    result->samplerate = samplerate;
    result->bipsa = bipsa;
    result->ba = channels*bipsa / 8;
    result->bypse = samplerate*result->ba;

    result->datatag[0] = 'd';
    result->datatag[1] = 'a';
    result->datatag[2] = 't';
    result->datatag[3] = 'a';
    result->datalength = datalength;

    result->data = data; // <--- that's were the data comes in

    return 0; // an error code, not implemented, yet ...; in Java: return result
}