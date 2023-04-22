# LotteryTicketServer
A lottery uses two servers to store individual tickets. These servers must replicate all ticket data. This means that both servers maintain separate collections of ticket data, but they must mirror each other. A Ticket consists of a seller code and six randomly chosen numbers in the range 1...40. Each server is a client of the other server. Ticket should use Serializable interface. A design for the system is given and your task is to implement a solution to the problem based on the given design. You are only tasked with completing the design given. You are not required to manage the draw or to save ticket data to file.
![image](https://user-images.githubusercontent.com/68587190/233771781-115136c2-7c56-4335-b5b3-d2eada658823.png)
