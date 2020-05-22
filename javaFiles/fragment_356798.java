public interface VirtualCompositeModel {

int getSize();
int getHeightAt(int index);
Control createElementAt(Composite parent, int index);

}