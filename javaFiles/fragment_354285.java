import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class BlockList {

    private List<Block> blockList;

    public BlockList() {
        this.blockList = new ArrayList<Block>();
    }

    public void init() {
        this.blockList.clear();
    }

    public void addBlock(Block block) {
        this.blockList.add(block);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < blockList.size(); i++) {
            blockList.get(i).draw(g);
        }
    }

}