public class Sector {

    private final int SIZE;
    private int[][] allocationTable;
    private Set<SubSector> subSectors = new HashSet<>();

    /**
     * Creates a new <code>Sector</code> of the specified size.
     * @param size the size of the sector
     */
    public Sector (int size) {

        SIZE = size;
        allocationTable = new int[SIZE][SIZE];
    }

    /**
     * Checks if a position in the grid is occupied by a {@link SubSector}.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return <code>true</code> if the position is occupied, <code>false</code> otherwise
     */
    public boolean isAllocated(int x, int y) {

        return (allocationTable[x][y] != 0);
    }

    /**
     * Calculates the free space originating at the given coordinates. A {@link SubSector} of this
     * maximum size or less can be allocated in this space.
     * @param x the x coordinate origin of the space
     * @param y the y coordinate origin of the space
     * @return the length of contiguous non-allocated space
     */
    public int getNonAllocatedSpaceAt(int x, int y) {

        int space = Math.min(SIZE-x, SIZE-y);
        for (int i = x; i < space +x ; i++) {
            for (int j = y; j < space + y; j++) {
                if (isAllocated(i, j))
                    return Math.max(i - x, j - y);
            }
        }
        return space;
    }

    /**
     * Gets the {@link SubSector} containing the specified coordinate.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the <code>SubSecotr</code> to which this space is allocated. <code>null</code> if
     * the space is not allocated.
     */
    public SubSector getSubSectorAt(int x, int y) {

        for (SubSector s : subSectors)
            if (s.number == allocationTable[x][y])
                return s;
        return null;
    }

    /**
     * Gets the {@link SubSector} specified by its number designation.
     * @param subSector the number designation of the <code>SubSector</code>
     * @return the designated <code>SubSector</code>.  <code>null</code> if the <code>SubSector</code>
     * does not exist.
     */
    public SubSector getSubSector(int subSector) {

        for (SubSector s : subSectors)
            if (s.number == subSector)
                return s;
        return null;
    }

    /**
     * Allocates the specified coordinate space to the specified {@link SubSector} and creates a new
     * <code>SubSector</code>. The <code>SubSector</code> must not already exist.
     * @param x the x coordinate origin of the space
     * @param y the y coordinate origin of the space
     * @param size the length of contiguous space to be allocated
     * @param subSector the number designation of the <code>SubSector</code>
     * @return <code>true</code> if the space was allocated, <code>false</code> otherwise
     */
    public boolean allocate(int x, int y, int size, int subSector) {

        if (getNonAllocatedSpaceAt(x, y) < size || !subSectors.add(new SubSector(x, y, size, subSector)))
            return false;
        for (int i = x; i < size + x; i++) {
            for (int j = y; j < size + y; j++) {
                allocationTable[i][j] = subSector;
            }
        }
        return true;
    }

    /**
     * Frees the space occupied by the specified {@link SubSector} and removes it.
     * @param subSector the <code>SubSector</code> to be removed
     * @return <code>true</code> if the space was deallocated, <code>false</code> otherwise
     */
    public boolean deallocate(int subSector) {

        return remove(getSubSector(subSector));
    }

    /**
     * Frees the space occupied by the {@link SubSector} occupying the specified coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return <code>true</code> if the space was deallocated, <code>false</code> otherwise
     */
    public boolean deallocate(int x, int y) {

        return remove(getSubSectorAt(x, y));
    }

    private boolean remove(SubSector sub) {

        if (!subSectors.remove(sub))
            return false;
        for (int i = sub.x; i < sub.size + sub.x; i++) {
            for (int j = sub.y; j < sub.size + sub.y; j++) {
                allocationTable[i][j] = 0;
            }
        }
        return true;
    }

    /**
     * Gets the allocation table for this <code>Sector</code>.
     * @return the allocation table for this <code>Sector</code>
     */
    public int[][] getAllocationTable() {

        return allocationTable;
    }

    /**
     * Gets the size of this <code>Sector</code>.
     * @return the size of this <code>Sector</code>
     */
    public int getSize() {

        return SIZE;
    }

    /**
     * Gets the (unsorted) {@link Set} of {@link SubSector}s in this <code>Sector</code>.
     * @return the <code>Set</code> of <code>SubSector</code>s in this <code>Sector</code>.
     */
    public Set<SubSector> getSubSectors() {

        return subSectors;
    }

    /**
     * A <code>SubSector</code> represents a square-shaped area in its parent {@link Sector}'s space.
     * A <code>SubSector</code> is designated (named) by a number and each parent <code>Sector</code>
     * can only contain one such <code>SubSector</code>.
     * A <code>SubSector</code> can only be created (and removed) by its parent <code>Sector</code>
     * and can never be modified (this prevents synchronizations issues with the allocation table),
     * however, its fields can be accessed directly.
     */
    public class SubSector {

        /** The x coordinate origin of this <code>SubSector</code>. */
        public final int x;
        /** The y coordinate origin of this <code>SubSector</code>. */
        public final int y;
        /** The length of this <code>SubSector</code>. */
        public final int size;
        /** The designation of this <code>SubSector</code>. */
        public final int number;

        private SubSector(int x, int y, int size, int number) {

            this.x = x;
            this.y = y;
            this.size = size;
            this.number = number;
        }
    }
}