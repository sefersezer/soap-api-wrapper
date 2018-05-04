package spring.webservice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.jws.WebService;

import org.tempuri.Address;
import org.tempuri.DQPigeonService;
import org.tempuri.DataQuality;
import org.tempuri.DqPigeonResult;

import com.paritus.client.ParitusClient;
import com.paritus.client.ParitusClientImpl;
import com.paritus.dto.AddressParseResult2;
import com.paritus.dto.ParsedAddress2;
import com.paritus.dto.ParsedToken;

@WebService(endpointInterface = "org.tempuri.DQPigeonService")
public class DQPigeonResponseImpl implements DQPigeonService {

	private static String APIKEY = "1dfb7584c6448d3b2f52c6d70b07f6d2df7fd497";
	private static String SERVER = "https://api1.paritus.com";

	@Override
	public DqPigeonResult dqPigeon(int transactionID, String address) {
		System.out.println(String.format(
				"islem alindi:\ntransaction id: %s , Input Address : %s ",
				transactionID, address));
		
		ParitusClient clientUser = new ParitusClientImpl(SERVER);
		clientUser.login(APIKEY); // LOGIN?
		AddressParseResult2 addressResult = new AddressParseResult2();
		
		try {
			String tmpAddressText = encodeText(address);
			tmpAddressText = String.format("address=%s&capitalizeoutput=true", tmpAddressText);
			addressResult = clientUser.verifyAddress(tmpAddressText);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		DqPigeonResult result = new DqPigeonResult();
		DataQuality dq = new DataQuality();
		dq.setAddress(fillAddressResponse(addressResult));
		dq.setTransactionID(transactionID);
		result.setDataQuality(dq);
		return result;
	}

	private Address fillAddressResponse(AddressParseResult2 addressResult) {
		ParsedAddress2 parsedAddress = addressResult.getParsedAddress();
		HashMap<String, String> tokens= getTokens(parsedAddress.getTokens()) ;
		
		Address returnAddress = new Address();
		returnAddress.setBINABLOK(getToken("BLOCK",tokens));//setBlankIfNull(parsedAddress.getBlock())
		returnAddress.setBINADAIRENO(getToken("HOUSENUMBER",tokens));
		returnAddress.setDAIRENO(getToken("UNIT",tokens));
		
		returnAddress.setCADDE(setBlankIfNull(parsedAddress.getMainStreet()));
		returnAddress.setDEPTH(setBlankIfNull(addressResult.getVerificationType()));
		returnAddress.setGEOCODEDIKEY(addressResult.getLongitude());
		returnAddress.setGEOCODEYATAY(addressResult.getLatitude());
		returnAddress.setIL(setBlankIfNull(parsedAddress.getCity()));
		returnAddress.setILCE(setBlankIfNull(parsedAddress.getTown()));
		returnAddress.setLOKASYON(setBlankIfNull(parsedAddress.getUndefined()));
		returnAddress.setMAHALLE(setBlankIfNull(parsedAddress.getQuarter()));
		returnAddress.setPOSTAKOD(setBlankIfNull(parsedAddress.getZipCode()));
		returnAddress.setSKOR(addressResult.getVerificationScore());
		returnAddress.setSOKAK(setBlankIfNull(parsedAddress.getStreet()));
		returnAddress.setTAMAMLANMAORANI(0f);//parsedAddress.getMatchScore().getScore()
		
		
		returnAddress.setULKE(getToken("COUNTRY",tokens));
		return returnAddress;
	}

	private String getToken(String string, HashMap<String, String> tokens) {
		if(tokens.containsKey(string)){
			return tokens.get(string);
		}
		return "";
	}

	public static String encodeText(String val)
			throws UnsupportedEncodingException {
		if (val != null) {
			val = URLEncoder.encode(val, "UTF-8");
		}
		return val;
	}

	public HashMap<String, String> getTokens(ParsedToken[] tokens){
		HashMap<String, String> myMap = new HashMap<String, String>();
		for(int i=0;i<tokens.length;i++){
			String prefix =setBlankIfNull(tokens[i].getPrefix());
			String text =setBlankIfNull(tokens[i].getText());
			String suffix =setBlankIfNull(tokens[i].getSuffix());
			myMap.put(tokens[i].getTokenType(), String.format("%s %s %s", prefix,text,suffix).trim());
		}
		return myMap;
	}
	
	public String setBlankIfNull(String val){
		if(val==null){
			return "";
		}
		else{
			return val;
		}
	}
}
