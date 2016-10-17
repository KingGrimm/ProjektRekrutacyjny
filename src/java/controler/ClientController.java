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

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

//zeby to bylo statickiem?
@ManagedBean
public class ClientController {

    private String temporaryName;
    private String temporarySurname;
    private String temporaryNumber;
    private String temporaryComment;

    static private int currentID;
    private static List<Client> listowadupa;
    private Client selectedClient;

    public void dupa() {
        /* FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dupa/;",  null);
         FacesContext.getCurrentInstance().addMessage(null, message);*/
        System.out.println("KOnsola KURWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA...kkkk");
    }

    public void addClient(/*int ID, Date date, String name, String surname, String telephone_number, String comment*/) {
        System.out.println("Name: " + temporaryName + " Surname: " + temporarySurname);
        listowadupa.add(new Client(temporaryName, temporarySurname, temporaryNumber, temporaryComment));
        listowadupa.get(listowadupa.size() - 1).setID(currentID);
        currentID++;
        System.out.println("Dodano klienta. Rozmiar vetora to " + listowadupa.size());
        System.out.println(listowadupa.get(listowadupa.size() - 1).toString());
        String dupa = "dupa";
        if (!dupa.contains("")) {
            System.out.println("Sukces");
        } else {
            System.out.println("porazka");
        }

    }

    public void addClient(String name, String surname, String telephone, String comment) {
        listowadupa.add(new Client(name, surname, telephone, comment));
        listowadupa.get(listowadupa.size() - 1).setID(currentID);
        currentID++;
    }

    void removeClient(String name, String surname) {
        //sprawdzic czy nie istnieje dwoch takich samych

    }

    void removeClient(String name, String surname, int id) {
        //sprawdzic czy nie istnieje dwoch takich samych

    }

    //eeee, to trzea ruszyc
    void editClient() {

    }

    void showClient() {

    }

    void searchClient() {

    }

    /*  public String getDate(){
        return Date.
    }*/
    public ClientController() {
        if (listowadupa == null) {
            listowadupa = new ArrayList<Client>();
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

    public void generateList() {
        addClient("Zdzislaw", "Kowalczyk", "61025465", "Anonimowy Alkoholik");
        addClient("Kamil", "Bednarek", "99562515", "Pantoflarz");
        addClient("Marek", "Tworek", "605965565", "");
    }

    public String deleteClient(String id) {
        removeClientWithId(id);
        return "/newxhtml.xhtml";
    }

    private void removeClientWithId(String id) {
        int idk = Integer.parseInt(id);
        System.out.println("Usunieto klienta o ID " + id);
        for (Client a : listowadupa) {
            if (a.getID() == idk) {
                listowadupa.remove(a);
                return;
            }
        }

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
        Client car = (Client) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + car.getID());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Client getSelectedClient() {
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
        if(temporaryComment==null)
            temporaryComment="";
        if(temporaryName==null)
            temporaryName="";
        if(temporaryNumber==null)
            temporaryNumber="";
        if(temporarySurname==null)
            temporarySurname="";
        
        List<Integer> toErease = new ArrayList<Integer>();

        for (int i = listowadupa.size()-1; i >= 0; i--) {
            if (( (listowadupa.get(i).getName()).contains(temporaryName)==false) || (listowadupa.get(i).getSurname().contains(temporarySurname)==false || listowadupa.get(i).getTelephone_number().contains(temporaryNumber)==false)
                    || listowadupa.get(i).getComment().contains(temporaryComment)==false) {
               findings.remove(i);
            }
        }
         System.out.println("Zawartosc findings po przeszukaniu:");
        System.out.println(findings);
        return findings;
    }

}
