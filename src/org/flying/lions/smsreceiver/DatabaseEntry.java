package org.flying.lions.smsreceiver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.flying.lions.smsreceiver.R;

public class DatabaseEntry {
    //public enum Bank { ABSA, FNB,   // AN IDEA
    short bank_id=-1; // 0 - absa, 1 - capitec
    short type_of_sale=-1; // 0 - purchase, 1 - deposit
    Date date_time;
    float amount=-1;
    float balance=-1;
    String place="N/A";   
    String bankName() {
        String bankstring = "";
        switch (bank_id) {
            case 0 : bankstring = "ABSA"; break;
            case 1 : bankstring = "Capitec"; break;
                default: bankstring = "unknown"; break;
        }
        return bankstring;
    }
    String transactionType() {
        String trans_type = "";
        switch (bank_id) {
            case 0 : trans_type = "Purchase"; break;
            case 1 : trans_type = "Deposit"; break;
                default: trans_type = "unknown"; break;
        }
        return trans_type;
    }
    @Override
    public String toString() {
    	
        String s="";
        
        DateFormat df = new SimpleDateFormat("dd/mm/yy");
        s+= "<b>Bank:</b> "+bankName()+"<br/>";
        s+= "<b>Transaction Type:</b> "+transactionType()+"<br/>";
        s+= "<b>Date:</b> "+df.format(date_time)+"<br/>";
        s+= "<b>Amount:</b> "+amount+"<br/>";
        s+= "<b>Balance:</b> "+balance+"<br/>";
        s+= "<b>Description:</b>"+place+"<br/>";    
        
        
        return s;
    }
    
}
