package org.telesoccorso.h2.util;

import org.jboss.logging.Logger;
import org.telesoccorso.webservice.TelemedicareServiceImpl;

public class H2StoredProcedures {
    private static final Logger logger = Logger.getLogger(H2StoredProcedures.class);
    public static boolean  storedProcedure(String telefono,String filename,String centrale) {
        logger.info(String.format("storedProcedure call telefono: %s filename: %s centrale: %s ",telefono,filename,centrale));
        return true;
    }

}
