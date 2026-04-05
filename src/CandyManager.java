import com.sun.source.tree.UsesTree;

import javax.swing.*;
import java.util.*;
public class CandyManager
{
    private List<Candy> candies;

    public CandyManager(){
        this.candies=new ArrayList<>();
    }

    public void addCandy(Candy candy){
        candies.add(candy);
    }

    public List<Candy> getAllCandies(){
        return candies;
    }

    public Candy findCandyById(String productId){
        for(Candy cd : candies){
            if(cd.getProductId().equalsIgnoreCase(productId)){
                return cd;
            }
        }
        return null;
    }

    public List<Candy>searchCandiesByName(String keyword)
    {

        ArrayList<Candy> list = new ArrayList<>();
        for(Candy cd : candies){
            if(cd.getProductName().equalsIgnoreCase(keyword)){
                list.add(cd);
            }
        }
        return list;
    }

    public List<Candy> getCandiesCanGetDiscount(){
        ArrayList<Candy> list = new ArrayList<>();
        for(Candy cd : candies){
            if(cd.canGetDiscount() == true){
                list.add(cd);
            }
        }
        return list;

    }

    public List<Candy> getTopCandies(int n){
        List<Candy> sorted = sortByRating(false);

        List<Candy> result = new ArrayList<>();
        for(int i=0; i < n && i  < sorted.size(); i++){
            result.add(sorted.get(i));
        }
        return result;
    }

    public List<Candy> sortByRating(boolean ascending){
        List<Candy> sorted = new ArrayList<>();
        int n = sorted.size();

        for (int i = 0; i < n; i++) {
            for(int j=0 ; j < n - i - 1 ; j++){
                double price1 = sorted.get(j).getRating();
                double price2 = sorted.get(j+1).getRating();
                boolean shouldSwap = ascending ? (price1 > price2) : ( price1 < price2);

                if(shouldSwap){
                    Candy temp = sorted.get(j);
                    sorted.set(j, sorted.get(j+1));
                    sorted.set(j+1,temp);
                }
            }
        }
        return sorted;
    }

    public List<Candy> sortByName(){
        ArrayList<Candy> sorted = new ArrayList<>();
        int n = sorted.size();

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n - i -1 ;j++){
                String name1= sorted.get(j).getProductName();
                String name2 = sorted.get(j+1).getProductName();

                if(name1.compareTo(name2) > 0){
                    Candy temp = sorted.get(j);
                    sorted.set(j, sorted.get(j+1));
                    sorted.set(j+1,temp);
                }
            }
        }
        return sorted;
    }


    public double calculateAverageRating(){
        double total = 0;
        for(Candy cd : candies){
            total += cd.getRating();
        }
        return total/candies.size();
    }

    public double calculateTotalRevenue(){
        double sum = 0;
        for(Candy cd : candies){
            sum += cd.calculateTotalPrice();
        }
        return sum;
    }


}
