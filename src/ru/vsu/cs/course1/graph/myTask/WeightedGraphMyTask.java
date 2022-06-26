package ru.vsu.cs.course1.graph.myTask;

import ru.vsu.cs.course1.graph.demo.GraphDemoFrame;
import ru.vsu.cs.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class WeightedGraphMyTask {
    private static Map<Integer, Integer> distance = new TreeMap<>();

    public static void addRoad() {
        GraphDemoFrame graphDemoFrame = new GraphDemoFrame();
        Integer[] arr = ArrayUtils.toIntegerArray(graphDemoFrame.weightTXT.getText());
        Integer firstPoint = 0;
        int distance = Integer.MAX_VALUE;
        int flag = 1;
        for (int i = 0; i <= arr.length; i++) {
            if ((flag == 1) && (i < arr.length)) {
                firstPoint = arr[i];
                flag++;
                i++;
            }

            if ((flag == 2) && (i < arr.length)) {
                flag++;
                i++;
            }

            if (flag == 3) {
                distance = arr[i];
                flag = 1;
            }
            if (i < arr.length) {
                WeightedGraphMyTask.distance.put(distance, firstPoint);
                distance = Integer.MAX_VALUE;
            } else {
                break;
            }
        }

    }

    public static ArrayList<Integer> findingCity(int n) {
        ArrayList<Integer> cities = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : distance.entrySet()){
            if(i.getKey() < n){
                cities.add(i.getValue());
            }
        }
        return cities;
    }
}
