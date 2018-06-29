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

    public int BusinessNumber;
    public String Name;
    public String PrimaryBussiness;
    public String Address;
    public String Province;

    public Contact() {

    }

    public Contact(int BusinessNumber, String Name, String PrimaryBussiness, String Address, String Province){
        this.BusinessNumber=BusinessNumber;
        this.Name = Name;
        this.PrimaryBussiness=PrimaryBussiness;
        this.Address=Address;
        this.Province=Province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("BusinessNumber", BusinessNumber);
        result.put("Name", Name);
        result.put("PrimaryBusiness", PrimaryBussiness);
        result.put("Address", Address);
        result.put("Province", Province);

        return result;
    }
}
