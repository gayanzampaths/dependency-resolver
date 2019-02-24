package gs.middlecube.tools.reader;

import java.io.File;

public class FileReaderUtil {
    static File loadPOM(String location){
        File file = null;
        try {
            file = new File(location);
        }catch (Exception e){
            e.printStackTrace();
        }
        return file;
    }

    public static File getPOMFile(String location){
        return loadPOM(location);
    }
}
