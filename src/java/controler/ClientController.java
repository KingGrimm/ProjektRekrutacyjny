/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;
import entities.Client;
import java.util.Date;
import java.util.Vector;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

//zeby to bylo statickiem?
@ManagedBean
public class ClientController {
    private static Vector<Client> listOfClients;

    public void dupa(){
        System.out.println("KOnsola KURWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA...kkkk");
    }
    
    public void addClient(int ID, Date date, String name, String surname, String telephone_number, String comment){
        listOfClients.add(new Client(ID,date,name,surname,telephone_number,comment));
        System.out.println("Dodano klienta");
    
    }
    void removeClient(String name, String surname){
        //sprawdzic czy nie istnieje dwoch takich samych
    
    }
    void removeClient(String name, String surname,int id){
        //sprawdzic czy nie istnieje dwoch takich samych
    
    }
    //eeee, to trzea ruszyc
    void editClient(){
        
    }
    void showClient(){
        
    }
    void searchClient(){
        
    }
}
