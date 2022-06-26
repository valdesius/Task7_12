package ru.vsu.cs.course1.graph;

/**
 * Реализация ориентированного графа (орграфа) на основе матрицы смежности
 */
public class AdjListsDigraph implements Graph, WeightedGraph {
    @Override
    public void addAdge(int v1, int v2, double weight) {

    }

    @Override
    public Iterable<WeightedEdgeTo> adjacenciesWithWeights(int v) {
        return null;
    }

    @Override
    public int vertexCount() {
        return 0;
    }

    @Override
    public int edgeCount() {
        return 0;
    }

    @Override
    public void addAdge(int v1, int v2) {

    }

    @Override
    public void removeAdge(int v1, int v2) {

    }

    @Override
    public Iterable<Integer> adjacencies(int v) {
        return null;
    }
    /**
     * Реализация полность совпадает
     * (в AdjListsGraph специально учтено)
     */
}
