package br.edu.fcv.oo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andre on 24/08/15.
 */
@XmlRootElement
public class Operation {

    private Details details;

    public Details getDetails() {
        return details;
    }

    @XmlElement
    public void setDetails(Details details) {
        this.details = details;
    }


    public String toXml() {
        return "<Operation>" + details.toXml()+
                "</Operation>" ;
    }
}
