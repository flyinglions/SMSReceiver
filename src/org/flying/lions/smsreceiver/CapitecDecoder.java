package org.flying.lions.smsreceiver;

import java.util.Date;
import org.flying.lions.smsreceiver.R;

public class CapitecDecoder extends Decoder {

    @Override
    DatabaseEntry decode(String smsdata) throws Exception {
        DatabaseEntry entry = new DatabaseEntry();
        
        
        entry.date_time = new Date(2000,01,01);
        return entry;
    }
    
}
