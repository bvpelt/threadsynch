package bsoft.nl;

public enum WorkState {
    INITIAL("INITIAL"),
    BUSY("BUSY"),
    READY("READY");

    private final String fieldDescription;

    private WorkState(String value) {
        fieldDescription = value;
    }

    public String toString() {
        return fieldDescription;
    }
}
