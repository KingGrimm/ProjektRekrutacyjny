/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.Date;

/**
 *
 * @author King
 */
@Named
@Dependent
public class Client {
private int ID;
private Date date;
private String name;
private String surname;
private String telephone_number;
private String comment;
    
    /**
     * Creates a new instance of Client
     */

    public Client(int ID, Date date, String name, String surname, String telephone_number, String comment) {
        this.ID = ID;
        this.date = date;
        this.name = name;
        this.surname = surname;
        this.telephone_number = telephone_number;
        this.comment = comment;
    }
    
    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Zmieniono nazwe na"+name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
   /* public static Client getClient(){
        return this;
    }*/
    
}
