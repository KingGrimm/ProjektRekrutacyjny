/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;
import entities.Client;
import java.util.ArrayList;
import java.util.List;

 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;

//zeby to bylo statickiem?

@ManagedBean
public class ClientController {
   
   
    private String temporaryName;
    private String temporarySurname;
    private String temporaryNumber;
    private String temporaryComment;
    static private int currentID;  
    private static List<Client> listowadupa;

 

    public void dupa(){
       /* FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dupa/;",  null);
         FacesContext.getCurrentInstance().addMessage(null, message);*/
        System.out.println("KOnsola KURWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA...kkkk");
    }
    
    public void addClient(/*int ID, Date date, String name, String surname, String telephone_number, String comment*/){
        System.out.println("Name: "+temporaryName+" Surname: "+temporarySurname);
        listowadupa.add(new Client(temporaryName,temporarySurname,temporaryNumber,temporaryComment));
        listowadupa.get(listowadupa.size()-1).setID(currentID);
        currentID++;
        System.out.println("Dodano klienta. Rozmiar vetora to "+listowadupa.size());
        System.out.println(listowadupa.get(listowadupa.size()-1).toString());  
    }
    public void addClient(String name,String surname,String telephone,String comment){
        listowadupa.add(new Client(name,surname,telephone,comment));
        listowadupa.get(listowadupa.size()-1).setID(currentID);
        currentID++;
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
    
  /*  public String getDate(){
        return Date.
    }*/

    public ClientController() {
        if(listowadupa==null)
        listowadupa=new ArrayList<Client>();
      
    }
  
    /* public void dodajkkk(/*Client a*)/*){
        a=
        a.setID(listOfClients.size());
        listOfClients.add(a);
        System.out.println("Dodano klienta. Rozmiar vetora to "+listOfClients.size());
        System.out.println(listOfClients.get(listOfClients.size()-1).toString());
    }*/

    public String getTemporaryName() {
        return temporaryName;
    }

    public void setTemporaryName(String temporaryName) {
        this.temporaryName = temporaryName;
    }

    public String getTemporarySurname() {
        return temporarySurname;
    }

    public void setTemporarySurname(String temporarySurname) {
        this.temporarySurname = temporarySurname;
    }

    public List<Client> getListowadupa() {
        for(int i=0;i<listowadupa.size();i++){
            System.out.println(listowadupa.get(i));
        }
        return listowadupa;
    }

    public void setListowadupa(List<Client> listowadupa) {
        this.listowadupa = listowadupa;
    }

    public String getTemporaryNumber() {
        return temporaryNumber;
    }

    public void setTemporaryNumber(String temporaryNumber) {
        this.temporaryNumber = temporaryNumber;
    }

    public String getTemporaryComment() {
        return temporaryComment;
    }

    public void setTemporaryComment(String temporaryComment) {
        this.temporaryComment = temporaryComment;
    }
    public void generateList(){
    addClient("Zdzislaw","Kowalczyk","61025465","Anonimowy Alkoholik");
    addClient("Kamil","Bednarek","99562515","Pantoflarz");
    addClient("Marek","Tworek","605965565","");
}
public String deleteClient(String id){
    removeClientWithId(id);
    return "/newxhtml.xhtml";
}

private void removeClientWithId(String id){
    int idk = Integer.parseInt(id);
    for(Client a:listowadupa){
        if(a.getID() == idk){
            listowadupa.remove(a);
            return;
        }
    }
}
 public void delete(ActionEvent actionEvent) {
        addMessage("Data deleted");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }





    
}
