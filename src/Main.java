import LotteryTicketServer.MainServer;
import LotteryTicketServer.TicketGenerator;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-04-22,Apr,2023
 * in Project: Default (Template) Project
 */

public class Main {
    public static void main(String[] args) {
        MainServer server1 = new MainServer();
        MainServer server2 = new MainServer();
        server1.setSecondaryServer(server2);
        server2.setSecondaryServer(server1);
        server1.setIsPrimary(true); //marking first server as main server, so that it can be identified clearly

        // Add some tickets to one of the servers
        TicketGenerator ticket1 = new TicketGenerator("GRYNDSLOTRYTKT1", new int[]{1, 2, 3, 4, 5, 6});
        TicketGenerator ticket2 = new TicketGenerator("GRYNDSLOTRYTKT2", new int[]{7, 8, 9, 10, 11, 12});
        server1.addTicket(ticket1);
        server1.addTicket(ticket2);

        // Replicating the data to the secondary server
        server1.replicate();

        // Print the tickets of both servers
        System.out.println("Server 1 tickets:");
        for (TicketGenerator ticket : server1.getTickets()) {
            System.out.println(ticket);
        }

        System.out.println("\nServer 2 tickets:");
        for (TicketGenerator ticket : server2.getTickets()) {
            System.out.println(ticket);
        }
    }
}