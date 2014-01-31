package worldMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

/**
 * For example, I used a CSV map loader for our project
 * @author ForexMaster
 *
 */
public class CsvWorldMapLoader implements WorldMapLoader {
    protected final static String FIELD_DELIMITER = ",";
    protected final static String ESCAPE_START = "\\Q";
    protected final static String ESCAPE_END = "\\E";
    protected final static String QUOTA = "\"";

    protected final static String ERROR_DATA_READ_EXCEPTION = "Read data exception";
    private final static Log log = LogFactory.getLog(CsvWorldMapLoader.class);

    public WorldMap load(String filePath) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filePath)));
        List<RowVector> data = new ArrayList<RowVector>();
        try {
            String line = reader.readLine();
            while (line != null) {
                String escapedLine = ESCAPE_START + line + ESCAPE_END;

                String[] fields = escapedLine.split(FIELD_DELIMITER);
                //remove \Q for the first record
                if (fields[0].startsWith(ESCAPE_START))
                    fields[0] = fields[0].substring(2);
                //remove \E for the last record
                int fl = fields.length;
                if (fields[fl - 1].endsWith(ESCAPE_END))
                    fields[fl - 1] = fields[fl - 1].substring(0, fields[fl - 1].length() - 2);

                RowVector row = new RowVector();

                List<String> purified = new ArrayList<String>();
                //skip the first element since it is a width
                for(int i=1; i<fields.length; i++){
                    String key = fields[i];
                    if(key.startsWith(QUOTA)){
                        key = key.substring(1);
                    }
                    if(key.endsWith(QUOTA)){
                        key = key.substring(0, key.length() - 1);
                    }
                    purified.add(key);
                }
                row.setVector(purified);

                data.add(row);
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new CoreException(ERROR_DATA_READ_EXCEPTION + " " + e.getMessage());
        }finally{
            try {
                reader.close();
            } catch (IOException e) {
                log.error("Failed to close file " + filePath + ": " + e.getMessage());
            }
        }

        return WorldMapBuilder.build(data);
    }
}