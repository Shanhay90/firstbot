package ru.aguzev.firstbot.custommodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ValuteCursOnDate", namespace = "")
public class ValuteCursOnDate {

    @XmlElement(name = "Vname", namespace = "")
    private String name;

    @XmlElement(name = "Vnom", namespace = "")
    private String number;

    @XmlElement(name = "Vcurs", namespace = "")
    private String course;

    @XmlElement(name = "Vcode", namespace = "")
    private String numericCode;

    @XmlElement(name = "VchCode", namespace = "")
    private String literalCode;
}
