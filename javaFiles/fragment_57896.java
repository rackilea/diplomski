@Override
public int compareTo(Note o) {
    if (time == o.time)
        return Integer.compare(noteNumber, o.noteNumber);
    else
        return Integer.compare(time, o.time);
}