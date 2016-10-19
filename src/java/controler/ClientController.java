/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entities.Client;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

//zeby to bylo statickiem?
@ManagedBean
@ViewScoped
public class ClientController {

    private String temporaryName;
    private String temporarySurname;
    private String temporaryNumber;
    private String temporaryComment;
    private String temporaryDate;
    private String temporaryID;

    static private int currentID;
    private List<Client> listowadupa;
    private static List<Client> zajebistalista;
    private List<Client> filteredClients;
    private Client selectedClient;

    public void dupa() {
        /* FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dupa/;",  null);
         FacesContext.getCurrentInstance().addMessage(null, message);*/
        System.out.println("KOnsola KURWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA...kkkk");
    }

    public void addClient(/*int ID, Date date, String name, String surname, String telephone_number, String comment*/) {
        FacesContext context = FacesContext.getCurrentInstance();
        String test=temporaryNumber.replaceAll("_", "");;
        if (test.length()>17) {
            System.out.println("Name: " + temporaryName + " Surname: " + temporarySurname+" NR: "+temporaryNumber);
            listowadupa.add(new Client(temporaryName, temporarySurname, temporaryNumber, temporaryComment));
            listowadupa.get(listowadupa.size() - 1).setID(currentID);
            currentID++;
            System.out.println("Dodano klienta. Rozmiar vetora to " + listowadupa.size());
            System.out.println(listowadupa.get(listowadupa.size() - 1).toString());
            temporaryName = "";
            temporarySurname = "";
            temporaryNumber = "";
            temporaryComment = "";
            zajebistalista = new ArrayList<>(listowadupa);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sukces",  "Klient został dodany do bazy") );     
        }
        else{
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Niepowodzenie",  "Sprawdź czy pola Imie, Nazwisko i Numer sa prawdiłowo wypełnione.") );  
        }

    }

    public void addClient(String name, String surname, String telephone, String comment) {
        listowadupa.add(new Client(name, surname, telephone, comment));
        listowadupa.get(listowadupa.size() - 1).setID(currentID);
        currentID++;

        zajebistalista = new ArrayList<>(listowadupa);
    }


    /*  public String getDate(){
        return Date.
    }*/
    public ClientController() {
        System.out.println("Powstaje nowy kontroler.");
        if (zajebistalista == null) {
            zajebistalista = new ArrayList<Client>();
        }
        if (listowadupa == null) {
            listowadupa = new ArrayList<Client>(zajebistalista);
        }

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
        for (int i = 0; i < listowadupa.size(); i++) {
            //       System.out.println(listowadupa.get(i));\
            ;
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

    public void generateList() {
        addClient("Zdzislaw", "Kowalczyk", "61025465", "Anonimowy Alkoholik");
        addClient("Kamil", "Bednarek", "99562515", "Pantoflarz");
        addClient("Marek", "Tworek", "605965565", "");
    }

    public void deleteClient(String id) {
        removeClientWithId(id);

    }

    public void deleteClientPusty() {
        removeClientWithId();

    }

    private void removeClientWithId(String id) {
        int idk = Integer.parseInt(id);
        System.out.println("Usunieto klienta o ID " + id);
        for (Client a : listowadupa) {
            if (a.getID() == idk) {
                listowadupa.remove(a);
                zajebistalista = new ArrayList<>(listowadupa);
                return;
            }
        }

    }

    private void removeClientWithId() {
        System.out.println("Rozpoczynam usuwanie puste");
        System.out.println("Usunieto klienta o ID " + selectedClient.getID());
        listowadupa.remove(selectedClient);
        selectedClient = null;
        zajebistalista = new ArrayList<>(listowadupa);

    }

    public void delete(ActionEvent actionEvent) {

        addMessage("Data deleted");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void chooseCar() {/*
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("editclient", options, null);*/
        System.out.println("Uzyto przycisku edit");
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("editclient");
    }

    public void onCarChosen(SelectEvent event) {
        Client client = (Client) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Wybrano klienta", "Id:" + client.getID());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Client getSelectedClient() {
        System.out.println("Wybrany klient: " + selectedClient);
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public void onRowEdit(RowEditEvent event) {
        
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Client Edited", "You succesfullly edited client with ID=" + String.valueOf(((Client) event.getObject()).getID()) + ".");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Client> findClient() {
        List<Client> findings = new ArrayList<Client>(listowadupa);
        System.out.println("Zawartosc nowego findings:");
        System.out.println(findings);
        if (temporaryComment == null) {
            temporaryComment = "";
        }
        if (temporaryName == null) {
            temporaryName = "";
        }
        if (temporaryNumber == null) {
            temporaryNumber = "";
        }
        if (temporarySurname == null) {
            temporarySurname = "";
        }
        if (temporaryDate == null) {
            temporaryDate = "";
        }
        if (temporaryID == null) {
            temporaryID = "";
        }

        for (int i = listowadupa.size() - 1; i >= 0; i--) {
            if (((listowadupa.get(i).getName()).contains(temporaryName) == false) || (listowadupa.get(i).getSurname().contains(temporarySurname) == false || listowadupa.get(i).getTelephone_number().contains(temporaryNumber) == false)
                    || listowadupa.get(i).getComment().contains(temporaryComment) == false || listowadupa.get(i).getDate().contains(temporaryDate) == false || Integer.toString(listowadupa.get(i).getID()).contains(temporaryID) == false) {
                findings.remove(i);
            }
        }
        System.out.println("Zawartosc findings po przeszukaniu:");
        System.out.println(findings);
        return findings;
    }

    public void addClientMenu() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("addingcleint", options, null);

    }

    public void onReturnAddingClient(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Returned", event.getObject().toString()));
    }

    public String getTemporaryDate() {
        return temporaryDate;
    }

    public void setTemporaryDate(String temporaryDate) {
        this.temporaryDate = temporaryDate;
    }

    public String getTemporaryID() {
        return temporaryID;
    }

    public void setTemporaryID(String temporaryID) {
        this.temporaryID = temporaryID;
    }

    public List<Client> getFilteredClients() {
        return filteredClients;
    }

    public void setFilteredClients(List<Client> filteredClients) {
        this.filteredClients = filteredClients;
    }

    /*  public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", (Integer.toString(((Client) event.getObject())).getID()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/
  
  
}
