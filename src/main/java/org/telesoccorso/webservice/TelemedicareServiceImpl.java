package org.telesoccorso.webservice;

import io.smallrye.common.constraint.Assert;
import org.jboss.logging.Logger;
import org.telesoccorso.domain.Esito;
import org.telesoccorso.domain.WsResult;
import org.telesoccorso.exception.TscException;
import org.telesoccorso.service.CodaEveServiceImpl;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.ServiceUnavailableException;

@WebService(serviceName = "TelemedicareService", portName = "TelemedicarePort",
        targetNamespace = "http://it.tsc.webservice/",
        endpointInterface = "org.telesoccorso.webservice.TelemedicareService")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public class TelemedicareServiceImpl implements TelemedicareService {
    private static final Logger logger = Logger.getLogger(TelemedicareServiceImpl.class);
    private static final String PHONE = "3515253473";
    private static final String CENTRALE = "MILANO";
    @Inject
    private CodaEveServiceImpl codaEveService;

    @WebMethod(action = "allarmeTelemedicare")
    @Override
    public WsResult allarmeTelemedicare(String progressivoAllarme) throws ServiceUnavailableException {
        WsResult result = null;
        try {
            Assert.assertNotNull(codaEveService);
            logger.info(String.format("allarmeTelemedicare progressivoAllarme: %s", progressivoAllarme));
            codaEveService.insertAllarmiInCodaEve_Brondi(PHONE,null,CENTRALE);
            result = new WsResult(Esito.OK, String.format("ricevuto inserisc1 allarme Telemedicate con progressivo %s", progressivoAllarme), 0, progressivoAllarme);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new TscException(e);
        }
        return result;
    }

    @WebMethod(action = "eliminaAllarmeTelemedicare")
    @Override
    public WsResult eliminaAllarmeTelemedicare(String progressivoAllarme) throws ServiceUnavailableException {
        WsResult result = null;
        try {
            Assert.assertNotNull(codaEveService);
            logger.info(String.format("eliminaAllarmeTelemedicare progressivoAllarme: %s", progressivoAllarme));
            result = new WsResult(Esito.OK, String.format("ricevuto eliminaAllarme con progressivo %s", progressivoAllarme), 0, progressivoAllarme);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new TscException(e);
        }
        return result;
    }
}
