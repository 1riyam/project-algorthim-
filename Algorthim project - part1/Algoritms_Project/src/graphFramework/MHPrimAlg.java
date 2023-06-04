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
package graphFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MHPrimAlg extends MSTAlgorithm {
    

    public void displayResultingMST(Graph graph) {
        // Get the source and target vertices from the graph
        Office source = graph.getSource();
        Office target = graph.getTarget();

        // Create a map to store the distances from the source vertex to each vertex in the graph
        Map<Office, Integer> distances = new HashMap<>();

        // Create a map to store the previous vertex in the shortest path from the source to each vertex in the graph
        Map<Office, Office> previous = new HashMap<>();

        // Create a set to keep track of visited vertices
        Set<Office> visited = new HashSet<>();

        // Initialize the distances to infinity and the previous vertices to null
        for (Office vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }

        // Set the distance to the source vertex to 0
        distances.put(source, 0);

        // Create a priority queue to store the vertices by their distances from the source vertex
        PriorityQueue<Office> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Add the source vertex to the priority queue
        pq.add((Office) source);
        

        // Process the vertices until the target vertex is visited
        while (!pq.isEmpty()) {
            Office current = pq.poll();

            if (current.equals(target)) {
                break;
            }

            // Add the current vertex to the visited set
            visited.add(current);

            // Update the distances and previous vertices for the neighbors of the current vertex
            for (Line edge : graph.getEdges()) {
                Office neighbor = (Office) edge.getTarget();

                if (edge.getSource().equals(current) && !visited.contains(neighbor)) {
                    int distance = distances.get(current) + edge.getWeight();

                    if (distance < distances.get(neighbor)) {
                        distances.put(neighbor, distance);
                        previous.put(neighbor, current);
                        pq.add(neighbor);
                    }
                }
            }
        }

        // Print the minimum path from the source to the target vertex
        if (!visited.contains(target)) {
            System.out.println("No path found from " + source.getLabel() + " to " + target.getLabel());
        } else {
            List<Office> path = new ArrayList<>();
            Office current = target;

            while (current != null) {
                path.add(current);
                current = previous.get(current);
            }

            Collections.reverse(path);

            System.out.print("The minimum path from " + source.getLabel() + " to " + target.getLabel() + " is: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" - ");
                }
            }
            System.out.println(", with cost " + distances.get(target));
        }
    }
}
//end 