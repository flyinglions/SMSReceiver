package org.flying.lions.smsreceiver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.flying.lions.smsreceiver.R;

import android.util.Log;


public class ABSADecoder extends Decoder {

    @Override
    DatabaseEntry decode(String smsdata) throws Exception {
        DatabaseEntry entry = new DatabaseEntry();
        
        //ABSA: CHEQ3291, Pur, 26/04/12 SETTLEMENT/C -POS PURCHASE, 000544654654844 RIDGE, R99.99, Balance R900.21
        
        String parts[] = smsdata.split(",");
        
        entry.bank_id = 0; // 0 for ABSA
        
        //Handling Type of Transaction
        if (smsdata.contains(" Pur,"))
            entry.type_of_sale = 0; // 0 - purchase
        else if (smsdata.contains(" Dep,"))
            entry.type_of_sale = 1; // 1 - deposit
        else 
            throw new Exception("Error. SMS format changed. Application needs updating.");
        
        try {
        String datestring = parts[2].trim().substring(0,parts[2].trim().indexOf(' '));
        //Log.v("ABSADecoder", datestring);
        //SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");        
        //entry.date_time = format.parse(datestring);
		
		DateFormat df = new SimpleDateFormat("dd/mm/yy");
		Date dateObj = (Date)df.parse(datestring);
        
        entry.date_time = dateObj;
        
        entry.place = parts[3].trim().substring(parts[3].trim().indexOf(' ')+1);
       
        entry.amount = Float.parseFloat(parts[4].substring(2));
        entry.balance = Float.parseFloat(parts[5].substring(parts[5].indexOf("R")+1));
        } catch (Exception e) {
            throw new Exception("Error. SMS format changed. Application needs updating.");
        }
        
        return entry;
    }
    
}
