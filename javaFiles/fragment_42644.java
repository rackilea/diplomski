// if you only want a "read more" suffix for long strings
String isi = a.getString(PNG_ISI);
if (isi.length() >= 100) {
    isi = isi.substring(0, 100) + "...(baca selengkapnya)";
}

// if you want to always have a "read more" suffix
String isi = a.getString(PNG_ISI);
isi = isi.substring(0, Math.min(isi.length(), 100)) + "...(baca selengkapnya)";