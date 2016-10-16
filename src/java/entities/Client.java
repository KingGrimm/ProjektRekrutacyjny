/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import controler.ClientController;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author King
 */

@ManagedBean
public class Client {

private int ID;
//private Date date;
private String name;
private String surname;
private String telephone_number;
private String comment;
    
/*
  <p:outputLabel for="date" value="Date: " />
        <p:inputMask id="date"  mask="99/99/9999" value="#{client.date}"/>
        <p:outputLabel for="phone" value="Phone:" />
        <p:inputMask id="phone"  mask="(+99) 999-99-99-99" value="#{client.telephone_number}"/>
      */
    /**
     * Creates a new instance of Client
     */

    
    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Client(/*int ID,*/String name, String surname /*Date date*/, String telephone_number, String comment) {
      //  this.ID = ID;
        //      this.date = date;
           this.name = name;
           this.surname = surname;
           this.telephone_number=telephone_number;
           this.comment=comment;
        //    this.telephone_number = telephone_number;
        //    this.comment = comment;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        System.out.println("Zmiana ID z "+this.ID+" na "+ID);
        this.ID = ID;
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
        System.out.println("Zmiana Surname z "+this.surname+" na "+surname);
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Client{" + "ID=" + ID + ", name=" + name + ", surname=" + surname + '}';
    }


    public Client() {
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
}
