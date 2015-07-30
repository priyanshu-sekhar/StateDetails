package StateDetails;

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

    }

    @Test
    public void testAddState() throws Exception {
        assertEquals(records.addRecord("ODISHA", "OD", "BHUBANESWAR", "ODIA"),"ODISHA,OD,BHUBANESWAR,ODIA");
    }

    @Test
    public void testGetState() throws Exception {
        assertEquals(records.getState("KA"), KAxml);
    }
}