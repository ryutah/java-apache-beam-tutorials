package client;

import org.apache.log4j.Logger;

public class Twitter implements Client {
    private static final long serialVersionUID = 1L;

    @Override
    public void publish(String message) {
        // Publishing message to twitter
        Logger logger = Logger.getLogger(this.getClass());
        logger.info(String.format("Post message : %s", message));
    }
}
