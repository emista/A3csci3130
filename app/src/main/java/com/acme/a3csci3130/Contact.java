package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */



public class Contact implements Serializable {
    /**
     * BusinessNumber: 9 digit number
     * Name: 2-48 characters
     * PrimaryBusiness:{Fisher, Distributor, Processor, Fish Monger}
     * Address: <50 characters
     * Province: {AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT, “ “}
     */

    public String bID;
    public String BusinessNumber;
    public String Name;
    public String PrimaryBusiness;
    public String Address;
    public String Province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * @param bID
     * @param BusinessNumber
     * @param Name
     * @param PrimaryBusiness
     * @param Address
     * @param Province
     */
    public Contact(String bID, String BusinessNumber, String Name, String PrimaryBusiness, String Address, String Province){
        this.bID=bID;
        this.BusinessNumber=BusinessNumber;
        this.Name = Name;
        this.PrimaryBusiness=PrimaryBusiness;
        this.Address=Address;
        this.Province=Province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("bID", bID);
        result.put("BusinessNumber", BusinessNumber);
        result.put("Name", Name);
        result.put("PrimaryBusiness", PrimaryBusiness);
        result.put("Address", Address);
        result.put("Province", Province);

        return result;
    }
}
