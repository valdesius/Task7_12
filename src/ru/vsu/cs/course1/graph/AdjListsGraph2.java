package ru.vsu.cs.course1.graph;

import java.util.*;

public class AdjListsGraph2 implements WeightedGraph{
    private List<List<Integer>> vEdjLists = new ArrayList<>();
    private int vCount = 0;
    private int eCount = 0;
    private static Iterable<Integer> nullIterable = new Iterable<Integer>() {
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Integer next() {
                    return null;
                }
            };
        }
    };

    @Override
    public void addAdge(int v1, int v2, double weight) {
        int maxV = Math.max(v1, v2);
        // добавляем вершин в список списков связности
        for (; vCount <= maxV; vCount++) {
            vEdjLists.add(null);
        }
        if (!isAdj(v1, v2)) {
            if (vEdjLists.get(v1) == null) {
                vEdjLists.set(v1, new LinkedList<>());
            }
            ArrayList t = new ArrayList();
            t.addAll(v1, Collections.singleton(weight));
            vEdjLists.get(v1).add(Integer.parseInt(t.toString()));
            eCount++;
            // для наследников
            if (!(this instanceof Digraph)) {
                if (vEdjLists.get(v2) == null) {
                    vEdjLists.set(v2, new LinkedList<>());
                }

                vEdjLists.get(v2).add(v1);
                //vEdjLists.get(v2).add((int) weight);
            }
        }
    }

    @Override
    public Iterable<WeightedEdgeTo> adjacenciesWithWeights(int v) {
        return null;
    }

    @Override
    public int vertexCount() {
        return vCount;
    }

    @Override
    public int edgeCount() {
        return eCount;
    }

    @Override
    public void addAdge(int v1, int v2) {
        int maxV = Math.max(v1, v2);
        // добавляем вершин в список списков связности
        for (; vCount <= maxV; vCount++) {
            vEdjLists.add(null);
        }
        if (!isAdj(v1, v2)) {
            if (vEdjLists.get(v1) == null) {
                vEdjLists.set(v1, new LinkedList<>());
            }
            vEdjLists.get(v1).add(v2);
            eCount++;
            // для наследников
            if (!(this instanceof Digraph)) {
                if (vEdjLists.get(v2) == null) {
                    vEdjLists.set(v2, new LinkedList<>());
                }
                vEdjLists.get(v2).add(v1);
            }
        }
    }

    @Override
    public void removeAdge(int v1, int v2) {

    }

    @Override
    public Iterable<Integer> adjacencies(int v) {
        return vEdjLists.get(v) == null ? nullIterable : vEdjLists.get(v);
    }
}