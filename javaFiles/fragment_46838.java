public WinNT.HRESULT D2D1CreateFactory(int factoryType, REFIID riid, D2D1_FACTORY_OPTIONS options, ID2D1Factory ppIFactory);

public class D2D1_FACTORY_OPTIONS extends Structure { ... }

D2D1_FACTORY_OPTIONS options = ...;
PointerByReference pref = new PointerByReference();

D2D1.INSTANCE.D2D1CreateFactory(0, new REFIID(...), options, pref);
ID2D1Factory factory = new ID2D1Factory(pref.getValue());