package serialization;

import com.thoughtworks.xstream.XStream;

public class XstreamTest {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        Student student = new Student();
        student.setAge(10);
        student.setName("Victor");

        String xml = xstream.toXML(student);
        System.out.println("Serialization: \n"+xml);

        System.out.println("------------------------------------------------");

        Student newJoe = (Student)xstream.fromXML(xml);
        System.out.println("Deserialization: \n"+newJoe);
    }

}
