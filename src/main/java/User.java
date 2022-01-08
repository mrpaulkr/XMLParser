import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "users")
public class User{
 @JacksonXmlProperty(localName = "firstName")
 private String firstName;
 @JacksonXmlProperty(localName = "lastName")
 private String lastName;
 @JacksonXmlProperty(localName = "role")
 private String role;
 @JacksonXmlProperty(localName = "position")
 private String position;
 @JacksonXmlProperty(localName = "phoneNumbers")
 @JacksonXmlElementWrapper(useWrapping = false)
 private List phoneNumbers = new ArrayList<>();

  private User() {
  }

 public String getFirstName() {
  return firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public String getRole() {
  return role;
 }

 @Override
 public String toString() {
  return "User{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", role='" + role + '\'' +
          ", position='" + position + '\'' +
          ", phoneNumbers=" + phoneNumbers +
          '}';
 }

 public String getPosition() {
  return position;
 }
 @JacksonXmlElementWrapper(useWrapping = false)
 public List<Integer> getPhoneNumbers() {
  return phoneNumbers;
 }

 public static UserBuilder newBuilder() {
  return new User().new UserBuilder();
 }


 public class UserBuilder {

  private UserBuilder() {
  }


  public UserBuilder setFirstName(String firstName){
   User.this.firstName = firstName;
   return this;
  }
  public UserBuilder setLastName(String lastName){
   User.this.lastName = lastName;
   return this;
  }
  public UserBuilder setRole(String role){
   User.this.role = role;
   return this;
  }
  public UserBuilder setPosition(String position){
   User.this.position = position;
   return this;
  }
  @JacksonXmlElementWrapper(useWrapping = false)
  public UserBuilder setPhoneNumbers(List<Integer> phoneNumbers){
   User.this.phoneNumbers = phoneNumbers;
   return this;
  }

  public User build(){
   return User.this;
  }
 }


}


