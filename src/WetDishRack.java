package dishWashS;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;

public class WetDishRack {
   private int currentDishes = 0;
   private int rackSize;
   private ArrayList<Integer> dishes = new ArrayList();
   private Semaphore rack;
   
	WetDishRack(int rackSize) {
	    /*create new rack semaphore with size rackSize*/
       rack = new Semaphore(rackSize);
       this.rackSize = rackSize;
	}
	
	public void addDish(int dish_id)  throws InterruptedException {
	    /*While rack is full, wait. Otherwise add new dish to the rack*/
         while(rack.availablePermits() == 0){
         //rack is full, wait until a dish is removed from the rack
         }
         rack.acquire();
         currentDishes++;
         dishes.add(dish_id);
	}
	
	public int removeDish() throws InterruptedException {
   	    /*While rack is empty, wait. Otherwise remove last dish from the rack*/
         while(rack.availablePermits() == rackSize){
         //rack is empty, loop until a dish is added
         }
         int count =  100;
         rack.release();
         return dishes.remove((currentDishes--) - 1);
	}
}