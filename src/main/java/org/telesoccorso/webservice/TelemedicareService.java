package org.telesoccorso.webservice;

import org.telesoccorso.domain.WsResult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.ServiceUnavailableException;
import javax.xml.soap.SOAPException;

@WebService
public interface TelemedicareService {

    /**
     * save allarm coming from WS
     * @param progressivoAllarme
     */
    @WebMethod
    WsResult allarmeTelemedicare(@WebParam(name = "progressivoAllarme", mode = WebParam.Mode.IN) String progressivoAllarme) throws SOAPException, ServiceUnavailableException;

    /**
     * retrieve List (size == 20) od persisted Allarms
     *
     * @return
     */
    @WebMethod
    WsResult eliminaAllarmeTelemedicare(
            @WebParam(name = "progressivoAllarme", mode = WebParam.Mode.IN) String progressivoAllarme) throws SOAPException, ServiceUnavailableException;

}
