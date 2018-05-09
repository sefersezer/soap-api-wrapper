package com.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataQuality {

  private int TransactionID;
  private Address Address;

  public int getTransactionId() {
    return TransactionID;
  }

  public void setTransactionId(int transactionId) {
    this.TransactionID = transactionId;
  }

  public Address getADDRESS() {
    return Address;
  }

  public void setADDRESS(Address address) {
    Address = address;
  }
}
