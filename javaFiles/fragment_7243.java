public class Composer {

    private StoregeManager storeManager; //Injected or initialized, as you want.
    private static Train train;

    public Composer build(){
        train = new Train;
        return this;
    }

    public Composer add(RollingStock rs) {
        if(rs.isValid(train))
            train.add(rs);
        return this;
    }

    public RollingStock[] build() {
        storageManager.ckeckTrain(train);
        return train;
    }
}