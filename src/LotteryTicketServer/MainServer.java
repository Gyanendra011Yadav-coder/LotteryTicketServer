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

    public void addTicketGenerator(TicketGenerator TicketGenerator) {
        this.TicketGenerators.add(TicketGenerator);
    }

    public List<TicketGenerator> getTicketGenerators() {
        return this.TicketGenerators;
    }

    public void setSecondaryServer(MainServer secondaryServer) {
        this.secondaryServer = secondaryServer;
    }

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public void replicate() {
        // Only the primary server replicates its data to the secondary
        if (isPrimary) {
            // Get the TicketGenerators from this server
            List<TicketGenerator> TicketGeneratorsToReplicate = getTicketGenerators();

            // Replicate the TicketGenerators to the other server
            for (TicketGenerator TicketGenerator : TicketGeneratorsToReplicate) {
                secondaryServer.addTicketGenerator(TicketGenerator);
            }
        }
    }
}
