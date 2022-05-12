package ex6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {

         People p1 = new People("001",21);
         People p2 = new People("002",33);
         People p3 = new People("003",41);
         
         //實作1:請實作一個「泛型」的Map中的key值為people的id，value為people物件，將上述三個people放入Map中
         Map<String,People> map = new HashMap<>();
         map.put(p1.getId(), p1);
         map.put(p2.getId(), p2);
         map.put(p3.getId(), p3);
         
         //實作2:請用for迴圈或者iterator，計算Map中三人的平均年齡，取到小數以下第一位
         int t_age = 0;
         double sum = 0d;
         Set<String> keyset = map.keySet();
         for (String k : keyset) {
        	 t_age += map.get(k).getAge();
        	 sum++;
         }
         double a_age = (double)t_age / sum;
         System.out.printf("平均年齡為: %.1f 歲%n", a_age);

    }
}
