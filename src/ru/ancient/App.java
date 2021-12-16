package ru.ancient;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ancient.pojo.TicketJsonPojo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        TicketJsonPojo ticketJson;
        ObjectMapper mapper = new ObjectMapper();

        try {
            ticketJson = mapper.readValue(new File("./tickets.json"),
                    TicketJsonPojo.class);
            System.out.println("Average fly time (minutes): ");
            System.out.println(averageFlyTime(ticketJson.getTicketList()));
            System.out.println("List of percentile 90: ");
            System.out.println(findPercentile(ticketJson.getTicketList(), 90));


        }catch (FileNotFoundException e){
            System.out.println("Put the tickets.json in JAR directory.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static long dateToSeconds(String date, String time) {
        String dateTime = date + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);

        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public static long timeInFly(TicketJsonPojo.Ticket ticket) {
        return (dateToSeconds(ticket.getArrivalDate(), ticket.getArrivalTime())
                - dateToSeconds(ticket.getDepartureDate(), ticket.getDepartureTime()));
    }

    public static long averageFlyTime(List<TicketJsonPojo.Ticket> ticketList) {
        long secondsRes = 0;

        for (TicketJsonPojo.Ticket ticket : ticketList) {
            secondsRes += timeInFly(ticket);
        }

        return secondsRes / ticketList.size() / 60;
    }

    public static List<Long> findPercentile(List<TicketJsonPojo.Ticket> ticketList, int percentile) {
        List<Long> tempList = new ArrayList<>();

        for (TicketJsonPojo.Ticket ticket : ticketList) {
            tempList.add(timeInFly(ticket) / 60);
        }

        double end = tempList.size() / 100.0 * percentile;
        Collections.sort(tempList);

        tempList = new ArrayList<>(tempList.subList(0, (int) end));
        return tempList;
    }




}
