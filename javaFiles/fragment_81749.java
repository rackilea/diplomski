//   ManaMain.java

public class ManaMain {

    public static void main(String[] args) {
        ManaCount manaCount = ManaCount.builder()
                .redManaCount(0)
                .whiteManaCount(0)
                .blueManaCount(0)
                .greenManaCount(0)
                .blackManaCount(0)
                .build();
        System.out.println(manaCount);
    }
}