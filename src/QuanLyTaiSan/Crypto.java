package QuanLyTaiSan;
class Crypto extends Asset {
    private String blockchain;

    public Crypto(String symbol, String name, double basePrice, String blockchain) {
        super(symbol, name, basePrice);
        this.blockchain = blockchain;
    }

    @Override
    public double calculateValue(double quantity) {
        return basePrice * quantity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Blockchain: " + blockchain;
    }
}