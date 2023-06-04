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

import java.util.List;
import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;
import java.util.HashSet;
import java.util.Set;

public abstract class MSTAlgorithm {
    //here i defines an abstract method. This method takes a graph object as input and is intended to display the minimum spanning tree of the graph.
    public static int x = 0;
    public abstract void displayResultingMST(Graph graph);
    //here this method takes a list of edge objects as input, which represents the minimum spanning tree of a graph, and is intended to display the minimum spanning tree and its total cost.
    public static void displayResultingMST(List<Line> MSTresultList) {
Set<String> printedEdges = new HashSet<>();
        //initializes the variable totalCost to 0, used to accumulate the total cost of the minimum spanning tree.
        int totalCost = 0;
        // Print the minimum spanning tree
        //this loop iterates over each edge object in the minimumSpanningTree list.
        for (Line edge : MSTresultList) {
            //here i extract the source vertex , target vertex and weight of the current edge object in the loop.
            Office source = (Office) edge.getSource();
            Office target = (Office) edge.getTarget();
            int weight = edge.getWeight();
            totalCost = totalCost + weight;
            // var a string edgeStr
            String edgeStr = "Office No. " + source.getLabel() + " - " + "Office No. " + target.getLabel() + " : " + weight;
            if (!printedEdges.contains(edgeStr)) {
                System.out.println(edgeStr);
                printedEdges.add(edgeStr);
            }
        }//end loop
        // here is a print statment 
        System.out.println("The cost of designed Phone network : " + totalCost);
    }

}
//end 