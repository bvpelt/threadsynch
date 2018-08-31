package bsoft.nl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.*;


import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * Hello world!
 */
public final class App implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private final List<String> args;

    public App(String... args) {
        this.args = unmodifiableList(asList(args));
    }

    public static void main(String[] args) {
        LOGGER.info("Hello World!");
        try {
            new App(args).run();
        } catch (Exception ex) {
            LOGGER.error("General error", ex);
        }
    }

    private void stop(final ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
            LOGGER.info("All tasks stopped");
        } catch (InterruptedException e) {
            LOGGER.error("Tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                LOGGER.error("Cancel non-finished tasks");
            }
            executor.shutdownNow();
            LOGGER.info("Shutdown finished");
        }
    }

    private void threadPoolTest() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> resultFuture01 = executor.submit(new BaseTask());
        Future<Integer> resultFuture02 = executor.submit(new MyTask());
        Future<Integer> resultFuture03 = executor.submit(new BaseTask());
        Future<Integer> resultFuture04 = executor.submit(new MyTask());

        Status s = Status.getInstance();

        Integer result01 = 0;
        Integer result02 = 0;
        try {
            LOGGER.info("Status ready: {}", resultFuture01.isDone());
            LOGGER.info("Status ready: {}", resultFuture01.isDone());
            result01 = resultFuture01.get();
            result02 = resultFuture02.get();
            LOGGER.info("Ready with result1: {}, result2: {}", result01, result02);
            LOGGER.info("Resultaat: {}", s.getData());
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted: {}", e);
        } catch (ExecutionException e) {
            LOGGER.error("Exception: {}", e);
        } finally {
            stop(executor);
        }
        LOGGER.info("All Ready with result: {}", result01);
    }

    //
    //
    private void threadPipeTest() {


    }

    @Override
    public void run() {
        threadPoolTest();
    }
}
