package Sản_Phẩm_Nội_Thất;

interface Furniture {
    String getProductId();
    String getProductName();
    double getRating();
    int getQuantity();
    double calculateTotalPrice();
    boolean canGetPromotion();

    boolean canGetDiscount();

    String getQualityRank();


}
