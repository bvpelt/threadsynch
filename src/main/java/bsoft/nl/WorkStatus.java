package bsoft.nl;

import java.util.HashMap;

public class WorkStatus {
    private static WorkStatus ourInstance = new WorkStatus();

    private HashMap<String, WorkState> womQueue = new HashMap<>();
    private HashMap<String, WorkState> wboQueue = new HashMap<>();
    private HashMap<String, WorkState> wdoQueue = new HashMap<>();

    private WorkStatus() {
    }

    public static WorkStatus getInstance() {
        return ourInstance;
    }

    synchronized public WorkState getWomStat(final String entiteit) {
        return womQueue.get(entiteit);
    }

    synchronized public void setWomState(final String entiteit, final WorkState workState) {
            womQueue.put(entiteit, workState);
    }

    synchronized public WorkState getWboState(final String entiteit) {
        return wboQueue.get(entiteit);
    }

    synchronized public void setWboState(final String entiteit, final WorkState workState) {
            wboQueue.put(entiteit, workState);
    }

    synchronized public WorkState getWdoState(final String entiteit) {
        return wdoQueue.get(entiteit);
    }

    synchronized public void setWdoState(final String entiteit, final WorkState workState) {
            wdoQueue.put(entiteit, workState);
    }

}
