package profitsoft.connection;


import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class ConnectionFactory {

    private static DataSource dataSource;

   static {
       Properties property = new Properties();
       Map<String, String> connectionInformstionContainer;
       ConnectionInformation connectionInformation = new ConnectionInformation();
       connectionInformation.setFile("connectionInf.txt");
       connectionInformstionContainer = connectionInformation.downloadConnectionInformation();
       property.setProperty("driverClassName", connectionInformstionContainer.get("driverClassName"));
       property.setProperty("url", "jdbc:mysql://" + connectionInformstionContainer.get("Database Host") + ":" + connectionInformstionContainer.get("Database Port") + "/" + connectionInformstionContainer.get("Database Name") + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
       property.setProperty("username", connectionInformstionContainer.get("Database User Name"));
       property.setProperty("password", connectionInformstionContainer.get("Database Password"));
       property.setProperty("maxActive", connectionInformstionContainer.get("maxActive"));
       property.setProperty("maxIdle", connectionInformstionContainer.get("maxIdle"));
       property.setProperty("maxWait", connectionInformstionContainer.get("maxWait"));
       property.setProperty("removeAbandoned", connectionInformstionContainer.get("removeAbandoned"));
       property.setProperty("removeAbandonedTimeout", connectionInformstionContainer.get("removeAbandonedTimeout"));
       property.setProperty("logAbandoned", connectionInformstionContainer.get("logAbandoned"));
       try {
           dataSource = BasicDataSourceFactory.createDataSource(property);
       } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
       }
   }

    public static Connection getMySQLConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
