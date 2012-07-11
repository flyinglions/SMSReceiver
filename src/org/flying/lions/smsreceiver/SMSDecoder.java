package org.flying.lions.smsreceiver;

import org.flying.lions.smsreceiver.R;

public class SMSDecoder {
    String rawsms = "";
    public  SMSDecoder(String smsdata) {
        rawsms = smsdata;
    }
    
    public DatabaseEntry recognizeAndDecode() throws Exception {
        DatabaseEntry entry = null;
        Decoder decoder = null;
        
        //The following code (UNTIL //**) will be variable:
        if (rawsms.startsWith("ABSA"))
            decoder = new ABSADecoder();
        if (rawsms.startsWith("Capitec"))
            decoder = new CapitecDecoder();
            
        //*************************************************
        
        if (decoder == null)
            return null;
        
        return decoder.decode(rawsms);
                    
        
    }
    
}
