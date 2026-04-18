import java.util.List;

/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() {
        super();
    }

    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) {
        super(size);
    }

    /**
     * Find the index for entry: if entry is in the table, then returns its
     * position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
        boolean firstLoop = true;
        int hashed = hashFunction(key);
        int target = hashed;
        incProbeCount();
        while (table[target] != null) {
            if (key.compareTo(table[target]) == 0) {
                return target;
            }
            target++;
            if (target >= tableSize() || (!firstLoop && target >= hashed)) {
                if (firstLoop) {
                    firstLoop = false;
                    target = 0;
                    if (hashed == 0)
                        return -1;
                } else {
                    return -1;
                }
            }
            incProbeCount();
        }
        return target;
    }
}
