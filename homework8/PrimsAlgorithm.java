import java.util.*;

// Class to represent an edge in the graph
class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Class to represent a node in the priority queue
class Node implements Comparable<Node> {
    int vertex;
    int key;

    public Node(int vertex, int key) {
        this.vertex = vertex;
        this.key = key;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.key, other.key);
    }
}

public class PrimsAlgorithm {

    private int vertices;
    private List<List<Edge>> adjacencyList;

    public PrimsAlgorithm(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an undirected weighted edge
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    // Prim's Algorithm
    public int[] primMST(int startVertex) {
        int[] key = new int[vertices];
        int[] parent = new int[vertices];
        boolean[] inMST = new boolean[vertices];

        // Initialize all keys as infinity
        Arrays.fill(key, Integer.MAX_VALUE);

        // Initialize all parents as -1
        Arrays.fill(parent, -1);

        // Priority queue (min-heap)
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        // Start from the given vertex
        key[startVertex] = 0;
        minHeap.add(new Node(startVertex, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int u = currentNode.vertex;

            // Skip if already included in MST
            if (inMST[u]) {
                continue;
            }

            inMST[u] = true;

            // Check all adjacent vertices
            for (Edge edge : adjacencyList.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                // Update key and parent if smaller edge is found
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    minHeap.add(new Node(v, key[v]));
                }
            }
        }

        return parent;
    }

    // Separate method to print MST
    public void printMST(int[] parent) {
        int totalWeight = 0;

        System.out.println("Edges in the Minimum Spanning Tree:");
        System.out.println("Edge \tWeight");

        for (int v = 0; v < vertices; v++) {
            if (parent[v] != -1) {
                int weight = getWeight(parent[v], v);
                System.out.println(parent[v] + " - " + v + "\t" + weight);
                totalWeight += weight;
            }
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }

    // Helper method to find weight between two vertices
    private int getWeight(int u, int v) {
        for (Edge edge : adjacencyList.get(u)) {
            if (edge.destination == v) {
                return edge.weight;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Sample graph from the image
        // Vertices: a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7, i=8
        PrimsAlgorithm graph = new PrimsAlgorithm(9);

        graph.addEdge(0, 1, 4);   // a-b
        graph.addEdge(0, 7, 8);   // a-h
        graph.addEdge(1, 2, 8);   // b-c
        graph.addEdge(1, 7, 11);  // b-h
        graph.addEdge(2, 3, 7);   // c-d
        graph.addEdge(2, 8, 2);   // c-i
        graph.addEdge(2, 5, 4);   // c-f
        graph.addEdge(3, 4, 9);   // d-e
        graph.addEdge(3, 5, 14);  // d-f
        graph.addEdge(4, 5, 10);  // e-f
        graph.addEdge(5, 6, 2);   // f-g
        graph.addEdge(6, 7, 1);   // g-h
        graph.addEdge(6, 8, 6);   // g-i
        graph.addEdge(7, 8, 7);   // h-i

        int startVertex = 0; // start from vertex a
        int[] mstParent = graph.primMST(startVertex);

        graph.printMST(mstParent);
    }
}