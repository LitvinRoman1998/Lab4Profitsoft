package profitsoft.connection;

import profitsoft.service.FileWorker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConnectionInformation extends FileWorker {
    public Map<String, String> downloadConnectionInformation(){
        if(file!=null){
            Map<String,String> connectionInf=new HashMap<>();
            String readLine;
            String key=null;
            String value=null;
            try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file))){
                while ((readLine = bufferedReader.readLine())!=null){
                    Scanner scanner=new Scanner(readLine);
                    scanner.useDelimiter(":");
                    while (scanner.hasNext()){
                        key=scanner.next();
                        value=scanner.next();
                    }
                    connectionInf.put(key,value);
                    scanner.close();
                }
                return connectionInf;
            } catch (IOException e) {
                System.out.println("Error"+e.getMessage());
            }
        }
        return new HashMap<>();
    }
}
