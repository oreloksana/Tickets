package Classes;

import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TicketAutomate {
    double ticketPrice;
    Tickets tickets = new Tickets();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DecimalFormat df = new DecimalFormat("##.##");


    public double getPrice(String ticketTyp) {
        switch (ticketTyp) {
            case "Ticket Zone M  price: 3.4 € ":
                ticketPrice = tickets.getPrice("Zone M " );
                return ticketPrice;
            case "Ticket Zone M - 1  price: 5.1 € ":
                ticketPrice = tickets.getPrice("Zone M - 1 ");
                System.out.println(ticketPrice);
                return ticketPrice;
            case "Ticket Zone M - 2  price: 6.8 € ":
                ticketPrice = tickets.getPrice("Zone M - 2 ");
                return ticketPrice;
            case "Ticket Zone M - 3  price: 8.5 € ":
                ticketPrice = tickets.getPrice("Zone M - 3 ");
                return ticketPrice;
            case "Ticket Zone M - 4  price: 10.2 € ":
                ticketPrice = tickets.getPrice("Zone M - 4 ");
                return ticketPrice;
            case "Ticket Zone M - 5  price: 11.9 € ":
                ticketPrice = tickets.getPrice("Zone M - 5 ");
                return ticketPrice;
            case "Ticket Zone M - 6  price: 13.6 € ":
                ticketPrice = tickets.getPrice("Zone M - 6 ");
                return ticketPrice;
        }
        System.out.println(ticketPrice);
        return ticketPrice;
    }

    public void transaction(boolean card, double price, AnchorPane dialog, double inCash, String typeOfTicket, LocalDate locDate, TextArea infoFeld) throws IOException {
        double inputCash;
        if(card){
            inputCash = price;
            dialog.setVisible(true);
            card=false;
        }else{
            inputCash = inCash;
        }
        if(price!=0 && inputCash>=price){
            String ticket = "###################################################### \r\n # You bought : " + typeOfTicket + ". \r\n # On: " +
                    locDate.format(formatter) + ".\r\n # You payed: " + df.format(inputCash)
                    + ".\r\n # Money back: " + df.format(inputCash - price) + "\r\n ######################################################";
            infoFeld.setText(ticket);
            new TicketWriter(ticket);
            DatabaseHandler databaseHandler = new DatabaseHandler();
            Date date = Date.valueOf(locDate);
            databaseHandler.addTicketToDB(typeOfTicket, price, date);
        } else infoFeld.setText("You didnt choose the ticket or entered not enough money. \n You entered: " + inputCash + ". \n Try again");
    }
}

