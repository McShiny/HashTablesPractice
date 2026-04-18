/**
 * Simple hash table implementation using quadratic probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class QPHashTable extends HashTable {

    /**
     * Create an QPHashTable with DEFAULT_SIZE table.
     */
    public QPHashTable() {
        super();
    }

    /**
     * Create an QPHashTable with the given default size table.
     */
    public QPHashTable(final int size) {
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
        int hashed = hashFunction(key);
        int target = hashed;
        int probe = 1;
        incProbeCount();
        while (table[target] != null) {
            if (key.compareTo(table[target]) == 0) {
                return target;
            }
            target = (hashed + (probe * probe)) % tableSize();
            if (probe >= tableSize()) {
                return -1;
            }
            incProbeCount();
            probe++;
        }
        return target;
    }
}
