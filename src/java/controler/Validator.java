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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author King
 */
@FacesValidator("mojValidator")
public class Validator implements javax.faces.validator.Validator {
    Client selectedClient;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        int counter = 0;
        ClientController a = new ClientController();
        List<Client> c=new ArrayList<Client>(a.getListowadupa());
        c.add(new Client());
        c.get(c.size()-1).setID(Integer.parseInt(String.valueOf(value)));
         c.add(new Client());
         c.get(c.size()-1).setID(Integer.parseInt(String.valueOf(value)));
         System.out.println(a.getSelectedClient());

        for (int i = 0; i < c.size(); i++) {
            if (Integer.parseInt(String.valueOf(value)) == c.get(i).getID()) {
                counter++;
                System.out.println("Counter: "+counter);
            }
        }
        if (counter>0&&(a.getSelectedClient().getID()!=Integer.parseInt(String.valueOf(value)))) {
            throw new ValidatorException(new FacesMessage("Dane ID już istnieje."));
        }
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }
    
}
