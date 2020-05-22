// assume GuitarPlayer has a play() method
metalBand.getGuitarPlayer().play();
folkBand.getGuitarPlayer().play();

// assume ElectricGuitarPlayer only has a whammy() method
ElectricGuitarPlayer electric = (ElectricGuitarPlayer) metalBand.getGuitarPlayer();
electric.whammy();
// assume AcousticGuitarPlayer only has a strum() method
AcousticGuitarPlayer acoustic = (AcousticGuitarPlayer) folkBand.getGuitarPlayer();
acoustic.strum();