import ConverterXML.XMLConverter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import objectsForXMLParsing.Book;
import objectsForXMLParsing.Catalog;
import objectsForXMLParsing.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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
        User developer = User.newBuilder()
                .setFirstName("Developer")
                .build();

        System.out.println(developer.toString());

    XMLConverter createXMLFromFile = new XMLConverter();
        File file = new File("books.xml");
        Catalog catalog = createXMLFromFile.XMLToCatalog(file);
        List<Book> books = new ArrayList<>();
        for(Book book: catalog.getBook()){
            books.add(book);
        }
        System.out.println(books.get(books.size()-1));











    }
}
