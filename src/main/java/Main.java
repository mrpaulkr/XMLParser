import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        XmlMapper mapper = new XmlMapper();
List<Integer> phoneNumbers = new ArrayList<>();
phoneNumbers.add(4234);
phoneNumbers.add(123456);

        User user = User.newBuilder()
                .setFirstName("TestName")
                .setLastName("LastName")
                .setRole("Developer")
                .setPhoneNumbers(phoneNumbers)
                .setPosition("Lead")
                .build();
        System.out.println(user);

//        User developer = User.newBuilder()
//                .setFirstName("Developer")
//                .build();
//
//        System.out.println(developer.toString());

    XMLConverter createXMLFromFile = new XMLConverter();
    createXMLFromFile.ObjectToXMLFile(user,"testList");
//
//        developer = createXMLFromFile.XMLFileToObject(developer,"testFile");
//
//        System.out.println(developer.toString());






    }
}
