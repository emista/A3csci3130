package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText numberField, nameField, primaryField, addressField, provinceField;
    Contact receivedBusinessInfo;
    /**
     * get current business info
     */
    private MyApplicationData appState;


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState=((MyApplicationData)getApplicationContext());

        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        primaryField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedBusinessInfo != null){
            numberField.setText(receivedBusinessInfo.BusinessNumber);
            nameField.setText(receivedBusinessInfo.Name);
            primaryField.setText(receivedBusinessInfo.PrimaryBusiness);
            addressField.setText(receivedBusinessInfo.Address);
            provinceField.setText(receivedBusinessInfo.Province);

        }
    }

    /**
     * @param v
     */
    public void updateContact(View v){
        //get key from firebase
        String businessID = receivedBusinessInfo.bID;

        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String primary = primaryField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact business = new Contact(businessID, number, name,primary,address, province);
        //Contact person = new Contact(personID, name, email);

        appState.firebaseReference.child(businessID).setValue(business);

        finish();
    }

    /**
     * @param v
     */
    public void eraseContact(View v)
    {
        appState.firebaseReference.child(receivedBusinessInfo.bID).removeValue();
        finish();
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
