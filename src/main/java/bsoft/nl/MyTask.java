package bsoft.nl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static java.lang.Math.abs;

public class MyTask extends TaskInterface<Integer> {
    static final Logger LOGGER = LogManager.getLogger(MyTask.class);

    Random r = new Random();

    private int randInt(final int maxInt) {

        return abs(r.nextInt()) % maxInt;
    }

    @Override
    public Integer doWork() {
        Integer result = 1;
        Status s = Status.getInstance();
        LOGGER.info("Start work");
        try {
            for (int i = 0; i < 1000; i++) {
                s.addChar('1');
                Thread.sleep(randInt(7));
            }
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e);
        }
        LOGGER.info("End   work");
        return result;
    }

}
