package mappers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class mappers {
    public static String openProps(String data) throws IOException {
        Properties props = new Properties();
        FileReader reader = new FileReader("src/main/resources/data.properties");
        props.load(reader);
        String result = props.getProperty(data);
        return result;
    }

    public static String getELements(String data) throws IOException {
        Properties props = new Properties();
        FileReader reader = new FileReader("src/main/resources/data.properties");
        props.load(reader);
        String result = props.getProperty(data);
        return result;
    }
}
