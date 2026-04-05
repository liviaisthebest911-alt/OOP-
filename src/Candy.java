interface Candy
{
    String getProductId();
    String getProductName();
    double getRating();
    int getQuantity();
    double calculateTotalPrice();
    boolean canGetDiscount();
    String getQualityRank();
}
