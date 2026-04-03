package OderPizza;

public class Order {
    private String orderId;
    private String symbol;
    private String type;
    private double price;
    private int quantity;
    private String status;

    public Order(String orderId,String symbol, String type, double price, int quantity, String status) {
        this.orderId = orderId;
        this.symbol= symbol;
        this.type = type;
        this.price=price;
        this.quantity=quantity;
        this.status="PENDING";
    }

    public Order(String orderId, String symbol, String type, double price, int quantity) {
    }

    public String getType(){
        return type;
    }
    public String getStatus(){
        return status;
    }
    public double getTotalValue(){
        return price*quantity;
    }
    public double getFee(){
        if(type.equals("BUY")){
            return getTotalValue()*0.001;
        }else{
            return getTotalValue()*0.015;
        }
    }

    public void match(){
        this.status="MATCHED";
    }

    public void cancel(){
        if(status.equals("PENDING")){
            this.status="CANCELLED";
        }
    }




}
