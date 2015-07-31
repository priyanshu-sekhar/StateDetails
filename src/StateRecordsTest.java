package StateDetails.src;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by test on 7/31/2015.
 */
public class StateRecordsTest {

    StateRecords records;
    String KAxml, TNxml, KLxml;
    @Before
    public void setUp() throws Exception {
        records = new StateRecords();
        KAxml = "<State><name>KARNATAKA</name><shortname>KA</shortname>" +
                "<headq>BANGALORE</headq><language>KANNADA</language></State>";
        TNxml = "<State><name>TAMILNADU</name><shortname>TN</shortname>" +
                "<headq>CHENNAI</headq><language>TAMIL</language></State>";
        KLxml = "<State><name>KERALA</name><shortname>KL</shortname>" +
                "<headq>TRIVANDRUM</headq><language>MALAYALAM</language></State>";

    }

    @Test
    public void testGetMsg() throws Exception {
        assertEquals(records.getMsg("TN"), TNxml);
        assertEquals(records.getMsg("Random"), StateConstants.NOT_FOUND);
    }

    @Test
    public void testAddRecord() throws Exception {
        assertEquals(records.addRecord("ODISHA", "OD", "BHUBANESWAR", "ODIA"),"ODISHA,OD,BHUBANESWAR,ODIA");
    }

    @Test
    public void testGetState() throws Exception {
        assertEquals(records.getState("KA"), KAxml);
        assertEquals(records.getState("Random"), StateConstants.NOT_FOUND);
    }
}