package navigationGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


/**
 * We use the Manhatten distance.
 *  To load a predefined navigation from a file,
 *   we use a loader class for this purpose.
 *   
 *   
 *   where the file is in JSON format, for example.

{"entries": [{"position":{"y":8.0,"x":8.0},"id":"A","linkWith":["B","C"],"extraData":["E01","E03","E05"]},
             {"position":{"y":6.0,"x":8.0},"id":"B","linkWith":["A","C"],"extraData":["E02","E04","E06"]},
             {"position":{"y":6.0,"x":6.0},"id":"C","linkWith":["A","B"],"extraData":["E01A"]}]
}

 * @author ForexMaster
 *
 */



public class NavGraphLoader {

    public NavGraphData load(String filePath) {
        try {
            String json = this.readFileAsString(filePath);
            JSONReader reader = new JSONReader();
            Map map = (Map) reader.read(json);
            NavGraphData data = new NavGraphData();
            data.fromJSON(map);

            return data;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + filePath);
        }
    }

    String readFileAsString(String filePath) throws java.io.IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filePath)));
        StringBuffer sb = new StringBuffer(4096);

        String line = reader.readLine();
        while(line != null){
            sb.append(line);
            line = reader.readLine();
        }

        reader.close();

        return sb.toString();
    }
    
   
}