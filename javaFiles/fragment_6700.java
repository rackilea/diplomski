//keep track of index for death record
int x = 0;
for (Iterator<Entry> iter = a.iterator(); iter.hasNext(); ++x) {

        final Entry next = iter.next();
        if (next.calories <= 0) {
            Fates.addDeathRecord(next.name, x, "starved to death");
            iter.remove();
        }

        else if (next.hydration <= 0) {
            Fates.addDeathRecord(next.name, x, "died of thirst");
            iter.remove();
        }

        else if (next.heat <= 0) {
            Fates.addDeathRecord(next.name, x, "froze to death");
            iter.remove();
        }

        else if (next.heat >= 14) {
            Fates.addDeathRecord(next.name, x, "overheated");
            iter.remove();
        }

        else if (next.moral <= Chance.randomNumber(0, 2)) {
            Fates.addDeathRecord(next.name, x, "commited suicide");
            iter.remove();
        }

}