package Sản_Phẩm_Nội_Thất;

 class DiscountFurniture implements Furniture{
    private String productId;
    private String productName;
    private double rating;
    private int quantity;
    private double discountAmount;

    public DiscountFurniture(String productId,String productName,double rating,int quantity, double discountAmount) {
        this.productId = productId;
        this.productName=productName;
        this.rating=rating;
        this.quantity=quantity;
        this.discountAmount=discountAmount;

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

    public double calculateTotalPrice(){
        double goc = quantity*50000;
        double tongThuc = goc - discountAmount;
        if(tongThuc < 0) return 0;

        return tongThuc;
    }

     @Override
     public boolean canGetPromotion() {
         return false;
     }

     @Override
    public boolean canGetDiscount() {
        if(quantity >= 3 && rating >= 8 ) return true;
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
        return "[NOI THAT GIAM GIA] Mã SP: "+productId+"\n"+
                "Tên SP: "+productName+"\n"+
                "Đánh giá: "+rating+"\n" +
                "Số lượng: "+quantity+"\n"+
                "Giảm giá: "+discountAmount+" VNĐ";

    }
}
