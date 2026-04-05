package QuanLyTaiSan;

abstract class Asset {
    protected String symbol;
    protected String name;
    protected double basePrice;

    public Asset(String symbol,String name,double basePrice ){
        this.symbol=symbol;
        this.name=name;
        this.basePrice=basePrice;
    }

    public abstract double calculateValue(double quantity);



    public String toString(){
        return String.format("Symbol: %s, Name: %s, Base Price: %.2f",
                symbol, name, basePrice);
    }


}
