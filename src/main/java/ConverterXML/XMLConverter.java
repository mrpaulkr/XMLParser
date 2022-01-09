package ConverterXML;

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

public class XMLConverter {
    XmlMapper mapper = new XmlMapper();
//    private objects.User user;

    public  File ObjectToXMLFile(User user,String fileName){
        File file = new File(fileName+".xml");
        try {
           mapper.writeValue(file,user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public User XMLFileToObject(User user, String fileName){
        File file = new File(fileName+".xml");
        try {
            user  = mapper.readValue(file,User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Book XMLFileToObjectBook(Book book, String fileName){
        File file = new File(fileName+".xml");
        try {
            book  = mapper.readValue(file,Book.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Catalog XMLToCatalog(File XMLfile){
        XMLConverter createXMLFromFile = new XMLConverter();
        Catalog catalog = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(XMLfile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return catalog;
    }

//    public String xmlToString(){
//
//
//
//        return "";
//
//    }

}
