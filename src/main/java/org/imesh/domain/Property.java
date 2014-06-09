package org.imesh.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by imesh on 6/9/14.
 */
@XmlRootElement
public class Property {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
