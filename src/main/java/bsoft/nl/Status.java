package bsoft.nl;

public class Status {
    private static Status ourInstance = new Status();

    private String data = "";

    private Status() {
    }

    public static Status getInstance() {
        return ourInstance;
    }

    public void addChar(char c) {
        data += c;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
