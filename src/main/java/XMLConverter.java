import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLConverter {
    XmlMapper mapper = new XmlMapper();
//    private User user;

    public  File ObjectToXMLFile(User user,String fileName){
        File file = new File(fileName+".xml");
        try {
           mapper.writeValue(file,user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public User XMLFileToObject(User user,String fileName){
        File file = new File(fileName+".xml");
        try {
            user  = mapper.readValue(file,User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

//    public String xmlToString(){
//
//
//
//        return "";
//
//    }

}
