package bsoft.nl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

abstract class TaskInterface<T> implements Callable<T> {
    static final Logger LOGGER = LogManager.getLogger(TaskInterface.class);

    abstract public T doWork();

    @Override
    public T call() throws Exception {
        LOGGER.info("Start");
        T result = null;

        result = doWork();

        LOGGER.info("End  ");
        return result;
    }
}
