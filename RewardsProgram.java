package nlbTechCodingAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardsProgram {
    // Define the rewards program rules
    private static final double REWARD_RATE_1 = 2.0;
    private static final double REWARD_RATE_2 = 1.0;
    private static final double MIN_SPEND_1 = 100.0;
    private static final double MIN_SPEND_2 = 50.0;
    
    public static void main(String[] args) {
        // Define the transactions for the three month period
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("customer1", "2022-01-01", 120.0));
        transactions.add(new Transaction("customer1", "2022-01-15", 70.0));
        transactions.add(new Transaction("customer1", "2022-02-01", 200.0));
        transactions.add(new Transaction("customer1", "2022-02-15", 90.0));
        transactions.add(new Transaction("customer1", "2022-03-01", 150.0));
        transactions.add(new Transaction("customer1", "2022-03-15", 80.0));
        
        // Calculate the reward points earned for each customer per month and total
        Map<String, Integer> rewardPointsPerMonth = new HashMap<>();
        int totalRewardPoints = 0;
        for (Transaction transaction : transactions) {
            // Calculate the reward points earned for each transaction
            double amount = transaction.getAmount();
            int rewardPoints = 0;
            if (amount > MIN_SPEND_1) {
                rewardPoints += (int) ((amount - MIN_SPEND_1) * REWARD_RATE_1);
            }
            if (amount > MIN_SPEND_2) {
                rewardPoints += (int) ((amount - MIN_SPEND_2) * REWARD_RATE_2);
            }
            
            // Add the reward points earned to the monthly and total rewards
            String[] dateParts = transaction.getDate().split("-");
            String month = dateParts[1];
            int monthlyRewardPoints = rewardPointsPerMonth.getOrDefault(month, 0) + rewardPoints;
            rewardPointsPerMonth.put(month, monthlyRewardPoints);
            totalRewardPoints += rewardPoints;
        }
        
        // Print the reward points earned for each customer per month and total
        for (Map.Entry<String, Integer> entry : rewardPointsPerMonth.entrySet()) {
            String month = entry.getKey();
            int monthlyRewardPoints = entry.getValue();
            System.out.println("Customer 1 earned " + monthlyRewardPoints + " reward points in month " + month);
        }
        System.out.println("Customer 1 earned a total of " + totalRewardPoints + " reward points");
    }
}