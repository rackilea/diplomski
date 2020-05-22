public class MapPosition extends Component
{
    public int x, y;

    public MapPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof MapPosition)) {
            return false;
        }

        MapPosition pos = (MapPosition)other;

        return (pos.x == this.x && pos.y == this.y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.x;
        hash = 59 * hash + this.y;
        return hash;
    }
}