package LotteryTicketServer;

import java.io.Serializable;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-04-22,Apr,2023
 * in Project: SerializedTicketGeneratorGeneratorSystem
 */
public class TicketGenerator implements Serializable {
    private String sellerCode;
    private int[] numbers;

    public TicketGenerator(String sellerCode, int[] numbers) {
        this.sellerCode = sellerCode;
        this.numbers = numbers;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(sellerCode).append(": ");
        for (int number : numbers) {
            sb.append(number).append(" ");
        }
        return sb.toString();
    }
}
