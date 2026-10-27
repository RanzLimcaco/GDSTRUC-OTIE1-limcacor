public class SavedPlayer {
    private String key;
    private Player player;
    private boolean deleted;

    public SavedPlayer(String key, Player player) {
        this.key = key;
        this.player = player;
        this.deleted = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
