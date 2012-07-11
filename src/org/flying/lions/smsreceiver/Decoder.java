package org.flying.lions.smsreceiver;

import org.flying.lions.smsreceiver.R;

public abstract class Decoder {
    abstract DatabaseEntry decode(String smsdata) throws Exception;
}

