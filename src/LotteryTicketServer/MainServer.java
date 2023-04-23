package LotteryTicketServer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-04-22,Apr,2023
 * in Project: SerializedTicketGeneratorSystem
 */
public class MainServer implements Serializable {
    private List<TicketGenerator> TicketGenerators;
    private MainServer secondaryServer;
    private boolean isPrimary;

    public MainServer() {
        this.TicketGenerators = new ArrayList<>();
    }

    public void addTicket(TicketGenerator TicketGenerator) {
        this.TicketGenerators.add(TicketGenerator);
    }

    public List<TicketGenerator> getTickets() {
        return this.TicketGenerators;
    }

    public void setSecondaryServer(MainServer secondaryServer) {
        this.secondaryServer = secondaryServer;
    }

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public void replicate() {
        // Only the primary server replicates its data to the secondary, we can identify this by using this boolean variable
        if (isPrimary) {
            // This will be Getting Tickets from this server
            List<TicketGenerator> TicketGeneratorsToReplicate = getTickets();

            // This will be Replicating the Tickets to the other server
            for (TicketGenerator TicketGenerator : TicketGeneratorsToReplicate) {
                secondaryServer.addTicket(TicketGenerator);
            }
        }
    }
}
