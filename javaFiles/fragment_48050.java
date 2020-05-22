public class IntBoxer {
    public IntBoxer() {
    }
    public IntBoxer(int startValue) {
        this.value = startValue;
    }
    public int value;
}
IntBoxer a = new IntBoxer();
IntBoxer b = new IntBoxer();
IntBoxer p;
Switch(whatever){
    case 1:
      p=a;
      break;
    case 2:
      p=b;
      break;
}
lots_of_lines_dealing_with_pointer_p.value;