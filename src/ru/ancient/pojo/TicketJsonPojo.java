package ru.ancient.pojo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TicketJsonPojo {

    @JsonProperty("tickets")
    List<Ticket> ticketList;

    public TicketJsonPojo() {
    }

    public TicketJsonPojo(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
    @JsonProperty("tickets")
    public List<Ticket> getTicketList() {
        return ticketList;
    }
    @JsonProperty("tickets")
    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public String toString() {
        return "TicketJsonPojo{" +
                "ticketList=" + ticketList +
                '}';
    }

    public static class Ticket {

        private String origin;
        private String originName;
        private String destination;
        private String destinationName;
        private String departureDate;
        private String departureTime;
        private String arrivalDate;
        private String arrivalTime;
        private String carrier;
        private Integer stops;
        private Integer price;

        public Ticket() {
        }
        @JsonCreator
        public Ticket(@JsonProperty("origin")String origin,
                      @JsonProperty("origin_name")String originName,
                      @JsonProperty("destination")String destination,
                      @JsonProperty("destination_name")String destinationName,
                      @JsonProperty("departure_date")String departureDate,
                      @JsonProperty("departure_time")String departureTime,
                      @JsonProperty("arrival_date")String arrivalDate,
                      @JsonProperty("arrival_time")String arrivalTime,
                      @JsonProperty("carrier")String carrier,
                      @JsonProperty("stops")Integer stops,
                      @JsonProperty("price")Integer price) {
            this.origin = origin;
            this.originName = originName;
            this.destination = destination;
            this.destinationName = destinationName;
            this.departureDate = departureDate;
            this.departureTime = departureTime;
            this.arrivalDate = arrivalDate;
            this.arrivalTime = arrivalTime;
            this.carrier = carrier;
            this.stops = stops;
            this.price = price;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getOriginName() {
            return originName;
        }

        public void setOriginName(String originName) {
            this.originName = originName;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getDestinationName() {
            return destinationName;
        }

        public void setDestinationName(String destinationName) {
            this.destinationName = destinationName;
        }

        public String getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(String departureDate) {
            this.departureDate = departureDate;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public String getArrivalDate() {
            return arrivalDate;
        }

        public void setArrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public Integer getStops() {
            return stops;
        }

        public void setStops(Integer stops) {
            this.stops = stops;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "origin='" + origin + '\'' +
                    ", originName='" + originName + '\'' +
                    ", destination='" + destination + '\'' +
                    ", destinationName='" + destinationName + '\'' +
                    ", departureDate='" + departureDate + '\'' +
                    ", departureTime='" + departureTime + '\'' +
                    ", arrivalDate='" + arrivalDate + '\'' +
                    ", arrivalTime='" + arrivalTime + '\'' +
                    ", carrier='" + carrier + '\'' +
                    ", stops=" + stops +
                    ", price=" + price +
                    '}';
        }
    }
}
