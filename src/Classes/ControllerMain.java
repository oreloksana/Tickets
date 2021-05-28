package Classes;

import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControllerMain {
    @FXML
    private ComboBox<String> typeOfTickets;
    @FXML
    private TextArea infoFeld;
    @FXML
    private AnchorPane dialog;
    @FXML

    private PasswordField pinField;
    private Tickets tickets = new Tickets();
    private Cash cash = new Cash();
    private TicketAutomate ticketAutomate = new TicketAutomate();
    private String typeOfTicket;
    private LocalDate locDate;
    private boolean card = false;


    public ControllerMain() throws IOException {
    }
    @FXML
    void initialize() {
        assert infoFeld != null : "fx:id=\"infoField\" was not injected: check your FXML file 'MainPage.fxml'.";
    }

    @FXML
    void buyTheTicket(MouseEvent event) throws IOException {
        typeOfTicket = String.valueOf(typeOfTickets.getValue());
        locDate = LocalDate.now();
        double inputCash = cash.getCash();
        ticketAutomate.transaction(card, dialog, inputCash, typeOfTicket, locDate,infoFeld);
    }
    @FXML
    void count100Euro(MouseEvent event) {
        cash.setCash(100);
    }

    @FXML
    void count10Cent(MouseEvent event) {
        cash.setCash(0.1);
    }

    @FXML
    void count10Euro(MouseEvent event) {
        cash.setCash(10);
    }

    @FXML
    void count1Euro(MouseEvent event) {
        cash.setCash(1);
    }

    @FXML
    void count20Cent(MouseEvent event) {
        cash.setCash(0.2);
    }

    @FXML
    void count20Euro(MouseEvent event) {
        cash.setCash(20);
    }

    @FXML
    void count2Euro(MouseEvent event) {
        cash.setCash(2);
    }

    @FXML
    void count50Cent(MouseEvent event) {
        cash.setCash(0.5);
    }

    @FXML
    void count50Euro(MouseEvent event) {
        cash.setCash(50);

    }

    @FXML
    void count5Euro(MouseEvent event) {
        cash.setCash(5);
    }

    @FXML
    void getMoneyFromTheCard(MouseEvent event) {
        card = true;
    }


    @FXML
    void showTickets(MouseEvent event) {
        typeOfTickets.setItems(tickets.givePossibleTickets());
    }

    @FXML
    void setInvisible(MouseEvent event) {
        dialog.setVisible(false);
    }
    @FXML
    void enterNumber(MouseEvent event) {
        pinField.setText("1");
    }
    @FXML
    void cancelTransaction(MouseEvent event) {
        dialog.setVisible(false);
        infoFeld.setText("Transaktion faild.Try again");
    }




}



