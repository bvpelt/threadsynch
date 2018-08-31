package bsoft.nl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestWorkStatus {
    static final Logger LOGGER = LogManager.getLogger(TestWorkStatus.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void addEnties() {
        LOGGER.info("start: {}", name.getMethodName());
        String [] keys = {"REFNR", "NPS", "NNP", "VES"};


        WorkStatus ws =  WorkStatus.getInstance();

        for (String key: keys) {
            ws.setWboState(key, WorkState.INITIAL);
        }

        for (String key: keys) {
            ws.setWboState(key, WorkState.BUSY);
        }

        for (String key: keys) {
            WorkState value = ws.getWboState(key);
            LOGGER.info("key: {}, value: {}", key, value);
        }


        LOGGER.info("end  : {}", name.getMethodName());
    }

}
