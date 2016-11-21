package de.bit.camel.security.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import de.bit.camel.security.OrdreDeMission;

/**
 * 
 * @author Rami TORKHANI
 */
@WebService(serviceName = "MissionInfoService", targetNamespace = "http://services.bit.de/")
public interface MissionInfoService {
    @WebResult(name = "mission")
    OrdreDeMission getOrdreDeMissionInformation(@WebParam(name = "sigId") String sigId);
}
