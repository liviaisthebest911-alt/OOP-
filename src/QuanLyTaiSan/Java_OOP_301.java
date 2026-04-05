package QuanLyTaiSan;


import java.io.*;
import java.util.*;

public class Java_OOP_301 {
    public static void main(String[] args) {
        List<Asset> list = new ArrayList<>();
        List<Double> quantities = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");

                if (parts.length < 6) {
                    System.out.println("Dòng lỗi: " + line);
                    continue;
                }

                String type = parts[0].trim();
                String symbol = parts[1].trim();
                String name = parts[2].trim();
                double basePrice = Double.parseDouble(parts[3].trim());

                if (type.equalsIgnoreCase("Stock")) {
                    String exchange = parts[4].trim();
                    double quantity = Double.parseDouble(parts[5].trim());

                    list.add(new Stock(symbol, name, basePrice, exchange));
                    quantities.add(quantity);

                } else if (type.equalsIgnoreCase("Crypto")) {
                    String blockchain = parts[4].trim();
                    double quantity = Double.parseDouble(parts[5].trim());

                    list.add(new Crypto(symbol, name, basePrice, blockchain));
                    quantities.add(quantity);
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
            return;
        }

        // In danh sách + tính tổng
        double total = 0;

        System.out.println("--- DANH SÁCH TÀI SẢN ---");
        for (int i = 0; i < list.size(); i++) {
            Asset a = list.get(i);
            double q = quantities.get(i);

            System.out.println(a);
            double value = a.calculateValue(q);
            System.out.println("Quantity: " + q);
            System.out.println("Value: " + value);
            System.out.println("----------------------");

            total += value;
        }

        System.out.println("👉 Tổng danh mục: " + total);
    }

}
