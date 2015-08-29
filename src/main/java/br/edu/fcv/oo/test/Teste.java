package br.edu.fcv.oo.test;

import br.edu.fcv.oo.Details;
import br.edu.fcv.oo.Operation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Andre on 22/08/15.
 */
public class Teste {

    public static final String USER_AGENT = "Mozilla/5.0";
    public static Operation customer;

    public static void main(String[] args) {
//        Esporte futebol = new Futebol();
//        Esporte basquete = new Basquete();
//        Esporte volei = new Volei();
//        Esporte handebol = new Hadebol();
//
//
//        futebol.setRegras(new RegrasFutebol());
//        futebol.exibeRegras();
//
//        handebol.setRegras(new RegrasHandebol());
//        handebol.exibeRegras();

        try {

            Operation op = new Operation();
            Details dt = new Details();
            dt.setGroup("grupo");
            dt.setCallbackURL("callback");
            dt.setDescription("description");
            dt.setLevel("level");
            dt.setRequester("request");
            dt.setRequesttemplate("template");
            dt.setService("email");
            dt.setSubject("sub");
            dt.setTechnician("tecnica");
            dt.setSite("site");
            op.setDetails(dt);
            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Operation.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(op, file);
            jaxbMarshaller.marshal(op, System.out);


            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            customer = (Operation) jaxbUnmarshaller.unmarshal(file);


            System.out.println(customer.toXml());
            sendPost();

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // HTTP POST request
    public static void sendPost() {
        try {

            String url = "http://servicedesk.sicoobpr.com.br/sdpapi/request";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            //define parameters
            String operation = "OPERATION_NAME=ADD_REQUEST";
            String techkey = "&TECHNICIAN_KEY=XXXXXXXXXXXXXXXXXXX";
            String data = "&INPUT_DATA=<Operation><Details><parameter><name>requester</name>               <value>Shawn Adams</value></parameter>"
                    + "<parameter><name>subject</name><value>The subject of the request</value></parameter>"
                    + "<parameter><name>description</name><value>The description of the request</value></parameter>"
                    + "<parameter><name>callbackURL</name><value>http://localhost:8080/CustomReportHandler.do</value></parameter>"
                    + "<parameter><name>requesttemplate</name><value>Unable to browse</value></parameter>"
                    + "<parameter><name>priority</name><value>High</value></parameter>"
                    + "<parameter><name>site</name><value>New York</value></parameter>"
                    + "<parameter><name>group</name><value>Network</value></parameter>"
                    + "<parameter><name>technician</name><value>Jeff Hein</value></parameter>"
                    + "<parameter><name>level</name><value>Tier 3</value></parameter>"
                    + "<parameter><name>status</name><value>Open</value></parameter>"
                    + "<parameter><name>service</name><value>Email</value></parameter>   </Details></Operation>";

            //String urlParameters = operation + techkey + data;

            String data1 = "&INPUT_DATA=" + customer.toXml();
            String urlParameters = operation + techkey + data1;

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
