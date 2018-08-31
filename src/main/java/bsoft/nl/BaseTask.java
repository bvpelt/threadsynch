package bsoft.nl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Math.abs;

public class BaseTask implements Callable<Integer> {
    static final Logger LOGGER = LogManager.getLogger(BaseTask.class);

    static int DEFAULT_DELAY = 7;
    int delay = DEFAULT_DELAY; // ms
    Random r = new Random();

    BaseTask() {
        delay = DEFAULT_DELAY;
    }

    BaseTask(final int delay) {
        this.delay = delay;
    }

    private int randInt(final int maxInt) {
        int result = abs(r.nextInt()) % maxInt;
        return result;
    }

    @Override
    public Integer call() throws Exception {
        LOGGER.info("Start and delay: {}", delay);
        WorkStatus ws = WorkStatus.getInstance();
        ws.setWboState("BASE", WorkState.INITIAL);
        Integer result = 0;
        Status s = Status.getInstance();
        try {
            ws.setWboState("BASE", WorkState.BUSY);
            for (int i = 0; i < 1000; i++) {
                s.addChar('0');
                Thread.sleep(randInt(delay));
            }
            result = 1;
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e);
        } finally {
            ws.setWboState("BASE", WorkState.READY);
        }
        LOGGER.info("End  ");
        return result;
    }
}
