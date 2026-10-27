public class SimpleHashtable {
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public boolean isOccuppied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player player) {
        int hashedKey = hashKey(key);

        // linear probing - find the next available space by iterating through the array
        if (isOccuppied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && isOccuppied(hashedKey)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccuppied(hashedKey)) {
            System.out.println("Value already exists at bucket " + hashedKey);
            return;
        }

        hashtable[hashedKey] = new SavedPlayer(player.getUserName(), player);
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);
        int stoppingIndex = hashedKey;

        while (hashtable[hashedKey] != null) {
            if (!hashtable[hashedKey].isDeleted()
                    && hashtable[hashedKey].getKey().equals(key)) {
                return hashedKey;
            }

            hashedKey = (hashedKey + 1) % hashtable.length;

            if (hashedKey == stoppingIndex) {
                break;
            }
        }

        return -1;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
            return null;

        return hashtable[hashedKey].getPlayer();
    }

    //remove function
    public Player remove(String key) {
        int hashedKey = hashKey(key);
        int stoppingIndex = hashedKey;

        while (hashtable[hashedKey] != null) {
            if (!hashtable[hashedKey].isDeleted()
                    && hashtable[hashedKey].getKey().equals(key)) {

                hashtable[hashedKey].setDeleted(true);
                return hashtable[hashedKey].getPlayer();
            }

            hashedKey = (hashedKey + 1) % hashtable.length;

            if (hashedKey == stoppingIndex) {
                break;
            }
        }

        return null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;

            if (hashtable[i] != null && !hashtable[i].isDeleted()) {
                player = hashtable[i].getPlayer();
            }

            System.out.println("Value at bucket " + i + " - " + player);
        }
    }
}