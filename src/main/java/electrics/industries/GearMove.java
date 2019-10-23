package electrics.industries;

public enum GearMove {
    DOWN(-1), NO(0), UP(1);

    private final int move;

    GearMove(int move) {
        this.move = move;
    }

    public int apply(int position) {
        return move + position;
    }
}
