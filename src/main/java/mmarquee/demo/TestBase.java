package mmarquee.demo;

import mmarquee.automation.controls.AutomationBase;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author Mark Humphreys
 * Date 19/05/2016.
 */
public class TestBase {

    protected Logger logger =
            LoggerFactory.getLogger(AutomationBase.class.getName());

    protected void rest() {
        try {
            Thread.sleep(1500);
        } catch (Exception ex) {
            logger.info("Interrupted");
        }
    }
}
