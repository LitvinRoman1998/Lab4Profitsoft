package profitsoft.connection;

import org.junit.Assert;
import org.junit.Test;
import profitsoft.connection.ConnectionInformation;

import java.util.HashMap;
import java.util.Map;

public class ConnectionInformationTest {
    @Test
    public void downloadConnectionInformationTest(){
        ConnectionInformation connectionInformation=new ConnectionInformation();
        connectionInformation.setFile("connectionInf.txt");
        Map<String,String> connInf=new HashMap<>();
        connInf.put("driverClassName","com.mysql.cj.jdbc.Driver");
        connInf.put("Database User Name","root");
        connInf.put("Database Password","12345678");
        connInf.put("Database Host","localhost");
        connInf.put("Database Port","3306");
        connInf.put("Database Name","insurance");
        connInf.put("maxActive","100");
        connInf.put("maxIdle","5");
        connInf.put("maxWait","-1");
        connInf.put("removeAbandoned","true");
        connInf.put("removeAbandonedTimeout","300");
        connInf.put("logAbandoned","false");
        Assert.assertEquals(connInf,connectionInformation.downloadConnectionInformation());
    }
}
