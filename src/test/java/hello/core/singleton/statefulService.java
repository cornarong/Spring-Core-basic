package hello.core.singleton;

public class statefulService {

//    private int price; // 상태를 유지하는 필드, 공유필드 10000 -> 20000

    public int order(String name, int price){
        System.out.println("name = "+name+"price = "+price);
//        this.price = price; // 여기가 문제 발생!!
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
