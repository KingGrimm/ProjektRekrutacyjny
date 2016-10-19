/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import entities.Client;
import entities.names_database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
    private List<Client> listofclients;
    private static List<Client> zajebistalista;
    private List<Client> filteredClients;
    private static Client selectedClient;
    
    /**
     * Metoda dodająca nowego klienta do listy.
     */
    public void addClient(/*int ID, Date date, String name, String surname, String telephone_number, String comment*/) {
        FacesContext context = FacesContext.getCurrentInstance();
        String test = temporaryNumber.replaceAll("_", "");;
        if (test.length() > 17) {
            System.out.println("Name: " + temporaryName + " Surname: " + temporarySurname + " NR: " + temporaryNumber);
            listofclients.add(new Client(temporaryName, temporarySurname, temporaryNumber, temporaryComment));
            listofclients.get(listofclients.size() - 1).setID(currentID);
            currentID++;
            System.out.println("Dodano klienta. Rozmiar vetora to " + listofclients.size());
            System.out.println(listofclients.get(listofclients.size() - 1).toString());
            temporaryName = "";
            temporarySurname = "";
            temporaryNumber = "";
            temporaryComment = "";
            zajebistalista = new ArrayList<>(listofclients);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukces", "Klient został dodany do bazy"));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Niepowodzenie", "Sprawdź czy pola Imie, Nazwisko i Numer sa prawdiłowo wypełnione."));
        }

    }

    public void addClient(String name, String surname, String telephone, String comment) {
        listofclients.add(new Client(name, surname, telephone, comment));
        listofclients.get(listofclients.size() - 1).setID(currentID);
        System.out.println("Dodane " + new Client(name, surname, telephone, comment));
        currentID++;
        System.out.println("Dodane " + new Client(name, surname, telephone, comment));

        zajebistalista = new ArrayList<>(listofclients);
    }


    /*  public String getDate(){
        return Date.
    }*/
    public ClientController() {
        System.out.println("Powstaje nowy kontroler.");
        if (zajebistalista == null) {
            zajebistalista = new ArrayList<Client>();
        }
        if (listofclients == null) {
            listofclients = new ArrayList<Client>(zajebistalista);
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

    public List<Client> getListofclients() {
        for (int i = 0; i < listofclients.size(); i++) {
            //       System.out.println(listowadupa.get(i));\
            ;
        }
        return listofclients;
    }

    public void setListofclients(List<Client> listofclients) {
        this.listofclients = listofclients;
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

    public void generateList(int number) {

 
        for (int i = 0; i < number; i++) {                  
          addClient(names_database.getRandomName(), names_database.getRandomSurname(), names_database.getRandomNumber(), "");
        }

        /*    addClient("Zdzislaw", "Kowalczyk", "61025465", "Anonimowy Alkoholik");
        addClient("Kamil", "Bednarek", "99562515", "Pantoflarz");
        addClient("Marek", "Tworek", "605965565", "");*/
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
        for (Client a : listofclients) {
            if (a.getID() == idk) {
                listofclients.remove(a);
                zajebistalista = new ArrayList<>(listofclients);
                return;
            }
        }

    }

    private void removeClientWithId() {
        System.out.println("Rozpoczynam usuwanie puste");
        System.out.println("Usunieto klienta o ID " + selectedClient.getID());
        listofclients.remove(selectedClient);
        selectedClient = null;
        zajebistalista = new ArrayList<>(listofclients);

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
        List<Client> findings = new ArrayList<Client>(listofclients);
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

        for (int i = listofclients.size() - 1; i >= 0; i--) {
            if (((listofclients.get(i).getName()).contains(temporaryName) == false) || (listofclients.get(i).getSurname().contains(temporarySurname) == false || listofclients.get(i).getTelephone_number().contains(temporaryNumber) == false)
                    || listofclients.get(i).getComment().contains(temporaryComment) == false || listofclients.get(i).getDate().contains(temporaryDate) == false || Integer.toString(listofclients.get(i).getID()).contains(temporaryID) == false) {
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
