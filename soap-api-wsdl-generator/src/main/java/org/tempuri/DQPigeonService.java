package org.tempuri;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.wrapper.DataQuality;

@WebService
public interface DQPigeonService {

  DataQuality DQPigeon(
      @WebParam(name = "TransactionID") int transactionID,
      @WebParam(name = "Address") String address);
}
