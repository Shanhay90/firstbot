package ru.aguzev.firstbot.custommodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlSeeAlso(ValuteCursOnDate.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ValuteData", namespace = "")
public class ValuteData {

    @XmlElement(name = "ValuteCursOnDate", namespace = "")
    private java.util.List<ValuteCursOnDate> cursOnDateList;
}
