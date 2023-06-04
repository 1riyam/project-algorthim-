/*
Group Members: 
2006847 Lujain Abdulaziz AlSulami
2005517 Asal Ali Alghamdi
2006739 Ryam Abdulwase Alsahafie 
2106125 Laura Ismail Fatta

References:
GeeksforGeeks. (2023b). Applications of Minimum Spanning Tree Problem. GeeksforGeeks. https://www.geeksforgeeks.org/applications-of-minimum-spanning-tree/

Poe - Fast, Helpful AI Chat. (n.d.). https://poe.com/

https://www.gatevidyalay.com/tag/kruskals-algorithm-example-with-solution/

Instructor :
I. أسماء الشنقيطي 
I. سيدرا قريشي

*/
package PhoneNetworkApp;

import graphFramework.Graph; 
import graphFramework.KruskalAlg;
import graphFramework.MHPrimAlg;
import graphFramework.MSTAlgorithm;
import java.util.Arrays;
import java.util.List;


public class PhoneNWDesignApp {
    public static void main(String[] args) {
        System.out.println("\n------------- Requirement 1 ----------------");
        Graph fiGraphst = new Graph();
        fiGraphst.readGraphFromFile("sampleInput.txt");
        MSTAlgorithm kruskal = new KruskalAlg();
        kruskal.displayResultingMST(fiGraphst);
        System.out.println("\n\n-------------Requirement 2-------------");
        List<Integer> vertexCounts = Arrays.asList(1000, 5000, 10000);
        List<List<Integer>> edgeCounts = Arrays.asList(
                Arrays.asList(10000, 15000, 25000),
                Arrays.asList(15000, 25000),
                Arrays.asList(15000, 25000)
        );
        // here i crate a for loop 
        for (int i = 0; i < vertexCounts.size(); i++) {
            int CountOFvertex = vertexCounts.get(i);
            List<Integer> edges = edgeCounts.get(i);
            // here i crate a for loop 
            for (int edgeCount : edges) {
                // here i start to generate a random graph
                long kruskalStartTime = System.nanoTime();
                Graph graaph = Graph.generateRandomGraph(CountOFvertex, edgeCount);
                long kruskalEndTime = System.nanoTime();
                long kruskalRunningTime = kruskalEndTime - kruskalStartTime;
                // here is the run min-heap-based Prim's algorithm and measure the running time
                long primStartTime = System.nanoTime();
                long primEndTime = System.nanoTime();
                long primRunningTime = primEndTime - primStartTime;
                // here i strar to print the running times
                System.out.println("\nVertex Count: " + CountOFvertex + ", Edge Count: " + edgeCount);
                System.out.println("Kruskal Running Time: " + kruskalRunningTime + " ns");
                System.out.println("Prim Running Time: " + primRunningTime + " ns");
                System.out.println();
            }
        }
    }
}
//end 