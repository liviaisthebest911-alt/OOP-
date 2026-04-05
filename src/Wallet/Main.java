package Wallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            String ownerName = sc.nextLine();
            double initialBalance = sc.nextDouble();
            sc.nextLine();

            Wallet wallet = new Wallet(ownerName, initialBalance);

            int n = sc.nextInt();
            sc.nextLine();

            for(int i=0; i < n ; i++){
                String line = sc.nextLine();
                String[] parts = line.split(" ");

                String command = parts[0];
                double amount = Double.parseDouble(parts[1]);

                try{
                    if(command.equals("DEPOSIT")){
                        wallet.deposit(amount);
                    } else if (command.equals("WITHDRAW")) {
                        wallet.withdraw(amount);
                    }
                }catch (IllegalArgumentException e){
                    // Bỏ qua lỗi nhưng vẫn lưu lịch sử
                }
            }
            //output
            System.out.println("Chu vi: " + wallet.getOwnerName());
            System.out.println("So du cuoi cung: " + String.format("%.1f", wallet.getBalance()));

            System.out.println("\nLich su giao dich:");
            int i = 1;
            for (String history : wallet.getTransactionHistory()) {
                System.out.println(i++ + ". " + history);
            }

        } catch (Exception e) {
            System.out.println("Input khong hop le!");
        }

        sc.close();
    }


}
