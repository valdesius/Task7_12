package ru.vsu.cs.course1.graph;

import java.util.ArrayList;

/**
 * Интерфейс для описания взвешенного ненаправленного графа (н-графа)
 * с реализацией некоторых методов
 */
public interface WeightedGraph extends Graph {

    /**
     * Интерфейс, описывающий связанную вершину с весом связи
     * (используется для перебора связанных вершин у конкретной вершины)
     */
    interface WeightedEdgeTo {
        int to();
        double weight();
    }

    /**
     * Добавление ребра между вершинами с номерами v1 и v2 c весом w
     * @param v1
     * @param v2
     * @param weight
     */
    void addAdge(int v1, int v2, double weight);

    /**
     * @param v Номер вершины, смежные с которой необходимо найти
     * @return Объект, поддерживающий итерацию по номерам связанных с v вершин
     */
    Iterable<WeightedEdgeTo> adjacenciesWithWeights(int v);

    /**
     * Проверка смежности двух вершин
     * @param v1
     * @param v2
     * @return
     */
    default double getWeight(int v1, int v2) {
        for (WeightedEdgeTo adj : adjacenciesWithWeights(v1)) {
            if (adj.to() == v2) {
                return adj.weight();
            }
        }
        return Double.POSITIVE_INFINITY;
    }

//    default ArrayList<String> findingCity(int n){
//        ArrayList<String> temp = new ArrayList<>();
//        for ()
//    }
}