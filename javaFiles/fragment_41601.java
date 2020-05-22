Identity identity = new Identity();
List<Slots> slots = new ArrayList<Slots>();

Slots slot = new Slots();
slot.setControlActualBias(Float.valueOf("1.23"));
slots.add(slot);

slot = new Slots();
slot.setControlActualBias(Float.valueOf("1.24"));
slots.add(slot);


identity.setSlots(slots);