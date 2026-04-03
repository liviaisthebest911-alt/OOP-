package OderPizza;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Order> list = new ArrayList<>();

        int k = Integer.parseInt(sc.nextLine());

        for(int i=0; i < k; i++){
            System.out.println("orderId: ");
            String orderId = sc.nextLine();

            System.out.println("symbol: ");
            String symbol = sc.nextLine();

            System.out.println("type (BUYE/SELL): ");
            String type = sc.nextLine();

            System.out.println("price: ");
            double price = Double.parseDouble(sc.nextLine());

            System.out.println("quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());

            Order o = new Order(orderId, symbol, type, price, quantity);

            System.out.print("Trạng thái (1=PENDING, 2=MATCHED, 3=CANCELLED): ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 2) {
                o.match();
            } else if (choice == 3) {
                o.cancel();
            }
            list.add(o);

        }

        //3.Tinh tong tien BUY( MATCHED)
        double totalBuy = 0;
        for(Order o : list){
            if(o.getType().equals("BUY") && o.getStatus().equals("MATCHED")){
                totalBuy += o.getTotalValue() + o.getFee();
            }
        }

        //4.Tinh tong tien Sell(Matched)
        double totalSell=0;
        for(Order o : list){
            if(o.getType().equals("SELL") && o.getStatus().equals("MATCHED")){
                totalSell += o.getTotalValue() - o.getFee();
            }
        }

        // 5. In kết quả tài chính
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Tổng tiền BUY phải trả: " + totalBuy);
        System.out.println("Tổng tiền SELL thu về: " + totalSell);



    }
}
