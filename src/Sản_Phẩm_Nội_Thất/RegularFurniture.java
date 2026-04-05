package Sản_Phẩm_Nội_Thất;
import java.util.*;
class RegularFurniture implements Furniture {
    private String productId;
    private String productName;
    private double rating;
    private int quantity;

    public RegularFurniture(String productId, String productName, double rating, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.rating = rating;
        this.quantity = quantity;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculateTotalPrice() {
        return quantity*500000;
    }

    @Override
    public boolean canGetPromotion() {
        if(quantity >= 3 && rating >= 8.0){
            return true;
        }
        return false;
    }
    @Override
    public String getQualityRank() {
        String[] parts= {"Yếu","Trung Bình","Khá","Giỏi","Xuất sắc"};

        int k=0;
        if(rating >= 5.0) k++;
        if(rating >= 6.5) k++;
        if(rating >= 8.0) k++;
        if(rating >= 9.0) k++;

        return parts[k];

    }
    public String toString(){
        return "[NOI THAT THUONG] Mã SP: "+productId+"\n"+
                "Tên SP: "+productName+"\n"+
                "Đánh giá: "+rating+"\n" +
                "Số lượng: "+quantity+"\n"+
                "Giảm giá: "+discountAmount+" VNĐ";

    }
}
