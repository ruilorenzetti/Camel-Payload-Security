package de.bit.camel.security.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import de.bit.camel.security.Signalement;

/**
 * 
 * @author Rami TORKHANI
 */
@WebService(serviceName = "SigInfoService", targetNamespace = "http://services.bit.de/")
public interface SigInfoService {
    @WebResult(name = "signalement")
    Signalement getSignalementInformation(@WebParam(name = "sigId") String sigId);
}
