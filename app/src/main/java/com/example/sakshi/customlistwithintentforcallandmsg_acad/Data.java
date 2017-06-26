package com.example.sakshi.customlistwithintentforcallandmsg_acad;

/**
 * Created by sakshi on 26-06-2017.
 */

public class Data {
    private String Name;
    private String Contact;
    //parameterized constructor

    public Data(String name, String Contact){
        this.Name = name;
        this.Contact= Contact;
    }
    //gtter methods for name and contact
    public String getName() {
        return Name;
    }
    public String getContact() {
        return Contact;
    }


}
