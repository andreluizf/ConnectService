package br.edu.fcv.oo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andre on 24/08/15.
 */
@XmlRootElement
public class Details {

    private String requester;
    private String subject;
    private String description;
    private String callbackURL;
    private String requesttemplate;
    private String site;
    private String group;
    private String technician;
    private String level;
    private String service;

    public String getRequester() {
        return requester;
    }
    @XmlElement
    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getSubject() {
        return subject;
    }
    @XmlElement
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }
    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCallbackURL() {
        return callbackURL;
    }
    @XmlElement
    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public String getRequesttemplate() {
        return requesttemplate;
    }
    @XmlElement
    public void setRequesttemplate(String requesttemplate) {
        this.requesttemplate = requesttemplate;
    }

    public String getSite() {
        return site;
    }
    @XmlElement
    public void setSite(String site) {
        this.site = site;
    }

    public String getGroup() {
        return group;
    }
    @XmlElement
    public void setGroup(String group) {
        this.group = group;
    }

    public String getTechnician() {
        return technician;
    }
    @XmlElement
    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public String getLevel() {
        return level;
    }
    @XmlElement
    public void setLevel(String level) {
        this.level = level;
    }

    public String getService() {
        return service;
    }
    @XmlElement
    public void setService(String service) {
        this.service = service;
    }


    public String toXml() {
        return "<Details>" +
                "<requester>" +requester  +"</requester>"   +
                "<subject>" + subject +"</subject>"   +
                "<description>" + description +"</description>"   +
                "<callbackURL>" + callbackURL +"</callbackURL>"   +
                "<requesttemplate>" + requesttemplate +"</requesttemplate>"   +
                "<site>" + site +"</site>"   +
                "<group>" + group +"</group>"   +
                "<technician>" + technician +"</technician>"   +
                "<level>" + level +"</level>"   +
                "<service>" + service +"</service>"

                +"</Details>"
                ;
    }

}
