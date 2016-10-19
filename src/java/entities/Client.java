/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import controler.ClientController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
/**
 *
 * @author King
 */

@ManagedBean
public class Client {

private int ID;
private LocalDate date;
private String string_date;
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
           this.date=LocalDate.now();
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
      //  System.out.println("Pobrano imie: "+name);
        return name;
    }

    public void setName(String name) {
      //  System.out.println("Zmieniono nazwe z "+this.name+" na "+name);
        this.name = name;
        
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
     //   System.out.println("Zmiana Surname z "+this.surname+" na "+surname);
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Client{" + "ID=" + ID + ", date=" + date + ", string_date=" + string_date + ", name=" + name + ", surname=" + surname + ", telephone_number=" + telephone_number + ", comment=" + comment + '}';
    }




    public Client() {
        this.date=LocalDate.now();
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

    public String getDate() {
        return date.toString();
    }

    public void setDate(String date) {
        try{
        LocalDate a=LocalDate.parse(date);
        System.out.println("Data widziana jako string: "+date+" Data widziana jako LD: "+a);
        this.date = a;
        }
        catch(Exception e){
              FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nie można zapisać", "Sprawdź format daty,");
        FacesContext.getCurrentInstance().addMessage(null, message);
        }
            
    }

    public String getString_date() {
        string_date=this.getDate();
        return string_date;
    }

    public void setString_date(String string_date) {
        this.string_date = string_date;
    }

    
}
