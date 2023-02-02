package org.telesoccorso;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;
import org.telesoccorso.webservice.TelemedicareServiceImpl;

@QuarkusMain
public class Application {

    private static final Logger logger = Logger.getLogger(Application.class);

    public static void main(String ... args) {
        logger.info("Running main method");
        Quarkus.run(args);
    }
}
