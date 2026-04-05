package Sản_Phẩm_Nội_Thất;
import java.util.*;

class FurnitureManager {
    private List<Furniture> furnitures;

    public Furniture(){
        this.furnitures = new ArrayList<>();
    }

    public void addFurniture(Furniture furniture){
        furnitures.add(furniture);
    }

    public Furniture findFurnitureById(String productId){
        for(Furniture fr : furnitures){
            if(fr.getProductId().equalsIgnoreCase(productId)){
                return fr;
            }
        }
        return null;
    }

    public List<Furniture> searchFurnituresByName(String keyword){
        ArrayList<Furniture> list = new ArrayList<>();
        for (Furniture fr : furnitures){
            if(fr.getProductName().contains(keyword)){
                list.add(fr);
            }
        }
        return list;
    }

    public List<Furniture> getFurnituresCanGetPromotion(){
        ArrayList<Furniture> list = new ArrayList<>();
        for(Furniture fr : furnitures){
            if(fr.canGetPromotion()){
                list.add(fr);
            }
        }
        return list;
    }

    public List<Furniture> getTopFurnitures(int n){
        ArrayList<Furniture> sorted = (ArrayList<Furniture>) sortByRating(false);;

        ArrayList<Furniture> result = new ArrayList<>();
        for(int i=0; i <= n && i <= sorted.size(); i++){
            result.add(sorted.get(i));
        }
        return result;
    }

    public List<Furniture> sortByRating(boolean ascending){
        ArrayList<Furniture> sorted = new ArrayList<>(furnitures);
        sorted.sort((a,b) ->
                ascending
                ? Double.compare(a.getRating(),b.getRating()) //tang dan
                : Double.compare(b.getRating(),a.getRating())   //giam dan
                );
        return sorted;
    }

    public List<Furniture> sortByName(List<Furniture> input, boolean ascending) {
        List<Furniture> list = new ArrayList<>(input);

        list.sort((a, b) ->
                ascending
                        ? a.getProductName().compareTo(b.getProductName())
                        : b.getProductName().compareTo(a.getProductName())
        );

        return list;
    }

    public double calculateAverageRating(){
        double sum=0;
        for(Furniture fr : furnitures){
            sum += fr.getRating();
        }
        return sum/furnitures.size();
    }
    public double calculateTotalRevenue(){
        double total=0;
        for(Furniture fr : furnitures){
            total += fr.calculateTotalPrice();
        }
        return total;
    }



}
